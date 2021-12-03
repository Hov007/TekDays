package com.tekdays

import grails.transaction.Transactional
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Transactional
class EmailService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TekEventController.class)

    def sendEmail() {
        LOGGER.info("Trying to send an Email with service")
        def u = TekUser.findByFullName('James Bond')
        if (u) {
            try {
                sendMail {
                    to u.email
                    subject "Test"
                    body "Test test test"
                }
            }
            catch (Exception e) {
                LOGGER.error "Problem sending email $e.message", e
            }
            LOGGER.info("Email was sent {}", u.email)
        }
    }
}

