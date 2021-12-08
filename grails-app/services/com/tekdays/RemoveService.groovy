package com.tekdays

import grails.transaction.Transactional

@Transactional
class RemoveService {

    def removeEvent() {
        def newDate = new Date()
        def events = TekEvent.findAllByEndDateLessThan(newDate)

        for (event in events) {
            try {
                sendMail {
                    to event.organizer.email
                    subject "Expired TekEvent"
                    body "Dear ${event.organizer.fullName}. Your '${event.name}' event has expired, please delete it.\n\nThank you in advance"
                }
            } catch (Exception e) {
                log.error "Problem sending email $e.message", e
            }
        }
    }
}