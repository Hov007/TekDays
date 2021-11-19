package com.tekdays

import grails.transaction.Transactional

@Transactional
class TaskService {

    def serviceMethod() { }

    def addDefaultTasks(tekEvent) {
        if (tekEvent.tasks?.size() > 0)
            return //We only want to add tasks to a new event
        tekEvent.addToTasks new Task(title: 'Identify potential venues')
        tekEvent.addToTasks new Task(title: 'Get price / availability of venues')
        tekEvent.addToTasks new Task(title: 'Compile potential sponsor list')
        tekEvent.save()
    }
}