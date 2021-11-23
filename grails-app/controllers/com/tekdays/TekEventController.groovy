package com.tekdays

import org.hibernate.envers.query.AuditQuery
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class TekEventController {
    def datatablesSourceService
    def taskService
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE", revisions: "PUT"]
    private static final Logger LOGGER = LoggerFactory.getLogger(TekEventController.class)

    def index() {
        // Querying Associations with Criteria
//        def criteria = TekEvent.withCriteria {
//            organizer {
//                ilike('userName', '%jdoe%')
//            }
//        }
//        println(criteria)

        // Querying with Projections
//        def criteria = TekEvent.createCriteria()
//        def count = criteria.get {
//            projections {
//                countDistinct('name')
//            }
//            organizer {
//                eq('userName', 'sarah')
//            }
//        }
//        println(criteria)
//        println(count)
        // A Simple Criteria Query
//        def events = TekEvent.createCriteria()
//        def results = events.list {
//            eq('city', 'Madrid   ')
//            like('name', '%Mad%')
//        }
//        println(results)

        // Dynamic Querying with Criteria
//        def queryMap = [city: 'Madrid']
//        def query = {
//            queryMap.each { key, value ->
//                if (value instanceof List) {
//                    println("yes it is")
//                }
//                else {
//                    like(key, value)
//                }
//            }
//        }
//        def events1 = TekEvent.createCriteria()
//        println events1.list(query)
        //  HQL via the findAll Method
//        def event = TekEvent.find('from TekEvent as a where a.name = ?',
//                            ['Real Madrid C.F.'])
//        println(event)


//        def results = TekEvent.list(max: 2, offset: 2)
//        println(results)
    }

    @Transactional
    def volunteer() {
        def event = TekEvent.get(params.id)
        event.addToVolunteers(session.user)
        event.save flush: true //remember about this f flush: true
        render "Thank you for Volunteering"
    }

    def dataTablesRenderer() {
        def propertiesToRender = ["name", "city", "description", "venue", "startDate", "id"]
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
