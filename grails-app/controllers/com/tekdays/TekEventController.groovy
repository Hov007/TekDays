package com.tekdays

import org.codehaus.groovy.grails.web.json.JSONObject
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import java.text.SimpleDateFormat

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

import grails.converters.*
import groovy.json.JsonOutput

//import grails.converters.deep.*

@Transactional(readOnly = true)
class TekEventController {
    def datatablesSourceService
    def taskService
    static allowedMethods = [save: "POST", update: "PUT",  revisions: "GET"]
    private static final Logger LOGGER = LoggerFactory.getLogger(TekEventController.class)

    @Transactional
    def index() {
//        Date newDate = new Date()
//        def events = TekEvent.findAllByEndDateLessThan(newDate)
//
//        for (event in events) {
//            event.delete()
//        }
    }


    def json = {
        def c = TekEvent.createCriteria()
        def event = c.list {}
        if (event) {
            def jsonify = event as JSON
            jsonify.prettyPrint = true
            render jsonify
        } else {
            response.sendError 404
        }
    }

    def xml = {
        def c = TekEvent.createCriteria()
        def event = c.list {}
        if (event) {
            withFormat {
                xml { render event as XML }
            }
        } else {
            response.sendError 404
        }
    }

    @Transactional
    def volunteer() {
        def event = TekEvent.get(params.id)
        event.addToVolunteers(session.user)
        event.save flush: true //remember about this f flush: true
        render "Thank you for Volunteering"
    }

    def dataTablesRenderer() {
        def propertiesToRender = ["name", "city", "description", "venue", "startDate", "endDate", "id" ]
        def entityName = 'TekEvent'
        render datatablesSourceService.dataTablesSource(propertiesToRender, entityName, params)
    }

//    def revisions() {
//        def auditQueryCreator = AuditReaderFactory.get(sessionFactory.currentSession).createQuery()
//
//        def revisionList = []
//        AuditQuery query = auditQueryCreator.forRevisionsOfEntity(TekEvent.class, false, true)
//        query.resultList.each {
//            if(it[0].id==params.getLong('id')) {
//                revisionList.add(it)
//            }
//        }
//        [revisionList: revisionList]
//    }

    def show(Long id) {
        def tekEventInstance
        if (params.nickname) {
            tekEventInstance = TekEvent.findByNickname(params.nickname)
        } else {
            tekEventInstance = TekEvent.get(id)
        }
        if (!tekEventInstance) {
            if (params.nickname) {
                flash.message = "TekEvent not found with nickname ${params.nickname}"
            } else {
                flash.message = "TekEvent not found with id $id"
            }
            redirect(action: "list")
            return
        }
        [tekEventInstance: tekEventInstance]
    }

    @Transactional
    def create() {
        respond new TekEvent(params)
        //[tekEventInstance: tekEventInstance]
    }

    @Transactional
    def save(TekEvent tekEventInstance) {
        if (tekEventInstance == null) {
            notFound()
            return
        }

        if (tekEventInstance.hasErrors()) {
            respond tekEventInstance.errors, view: 'create'
            return
        }

        tekEventInstance.save flush: true
        taskService.addDefaultTasks(tekEventInstance)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'tekEvent.label', default: 'TekEvent'), tekEventInstance.id])
                redirect tekEventInstance
            }
            '*' { respond tekEventInstance, [status: CREATED] }
        }
    }

    def edit(TekEvent tekEventInstance) {
        respond tekEventInstance
    }

    @Transactional
    def update(TekEvent tekEventInstance) {
        if (tekEventInstance == null) {
            notFound()
            return
        }

        if (tekEventInstance.hasErrors()) {
            respond tekEventInstance.errors, view: 'edit'
            return
        }

        tekEventInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'TekEvent.label', default: 'TekEvent'), tekEventInstance.id])
                redirect tekEventInstance
            }
            '*' { respond tekEventInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(TekEvent tekEventInstance) {

        if (tekEventInstance == null) {
            notFound()
            return
        }

        tekEventInstance.delete flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'TekEvent.label', default: 'TekEvent'), tekEventInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }


    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'tekEvent.label', default: 'TekEvent'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }


}