package com.tekdays

class TekDaysTagLib {
//    static defaultEncodeAs = [taglib:'html']
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]
    def messageThread = { attrs ->
        def messages = attrs.messages.findAll { msg -> !msg.parent }
        processMessages(messages, 0)
    }

    void processMessages(messages, indent) {
        messages.each { msg ->
            def body = "${msg?.author} - ${msg?.subject}"
            out << "<p style='height:35; margin-left:${indent * 20}px;'>"
            out << "${remoteLink(action: 'showDetail', id: msg.id, update: 'details', body)}"
            out << "</p>"
            def children = TekMessage.findAllByParent(msg)
            if (children) {
                processMessages(children, indent + 1)
            }
        }
    }

    def loginToggle = {
        out << "<div style='margin: 15px 0 40px;'>"
        if (request.getSession(false) && session.user) {
            out << "<span style='float:left; margin-left: 15px'>"
            out << "${message(code: 'tekDays.welcome')} ${session.user}."
            out << "</span><span style='float:right;margin-right:15px'>"
            out << "<a href='${createLink(controller: 'tekUser', action: 'logout')}'>"
            out << "${message(code: 'tekDays.logout')} </a></span>"
        } else {
            out << "<span style='float:right;margin-right:10px'>"
            out << "<a href='${createLink(controller: 'tekUser', action: 'login')}'>"
            out << "${message(code: 'tekDays.login')} </a></span>"
            out << "<span style='float:right;margin-right:20px'>"
            out << "<a href='${createLink(controller: 'tekUser', action: 'signup')}'>"
            out << "${message(code: 'tekDays.signup')} </a></span>"
        }
    }

    def json = {
        out << "<a target='_blank' href=\"${createLink(controller: 'tekEvent', action: 'json')}\">"
        out << "JSON </a>"
    }

    def xml = {
        out << "<a target='_blank' href=\"${createLink(controller: 'tekEvent', action: 'xml')}\">"
        out << "XML </a>"
    }

    def organizerEvents = {
        if (request.getSession(false) && session.user) {
            def events = TekEvent.findAllByOrganizer(session.user)
            if (events) {
                out << "<div style='margin-left:25px; margin-top:25px; width:85%'>"
                out << "<h3 id=\"textTitles\">${message(code: 'tekDays.event.organizing')}</h3>"
                out << "<ol>"
                events.each {
                    out << "<li id='evn'><a href='"
                    out << "${createLink(controller: 'tekEvent', action: 'show', id: it.id)}'>"
                    out << "${it}</a></li>"
                }
                out << "</ol>"
                out << "<span class=\"buttons\"></span>"
                out << "</div>"
            }
        }
    }

    def volunteerEvents = {
        if (request.getSession(false) && session.user) {
            def events = TekEvent.createCriteria().list {
                volunteers {
                    eq('id', session.user?.id)
                }
            }
            if (events) {
                out << "<div style='margin-left:25px; margin-top:25px; width:85%'>"
                out << "<h3 id=\"textTitles\">${message(code: 'tekDays.event.volunteered')}</h3>"
//                out << "<ul>"
                events.each {
                    out << "<li id='asd'><a href='"
                    out << "${createLink(controller: 'tekEvent', action: 'show', id: it.id)}'>"
                    out << "${it}</a></li>"
                }
                out << "</ul>"
                out << "<span class=\"buttons\"></span>"
                out << "</div>"
            }
        }
    }

    def volunteerButton = { attrs ->
        if (request.getSession(false) && session.user) {
            def user = session.user.merge()
            def event = TekEvent.get(attrs.eventId)
            if (event && !event.volunteers.contains(user)) {
                out << "<span id='volunteerSpan' class='menuButton'>"
                out << "<button id='volunteerButton' type='button'><i class=\"fas fa-handshake\"> </i>"
                out << "_Volunteer For This Event"
                out << "</button>"
                out << "</span>"
            }
        }
    }
}
