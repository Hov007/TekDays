package com.tekdays

import org.hibernate.envers.Audited


@Audited
class TekEvent {
    String city
    String name
    TekUser organizer
    String venue
    Date startDate
    Date endDate
    String description
    String nickname
    Date lastUpdated

    static hasMany = [volunteers : TekUser, respondents: String, sponsorships : Sponsorship, tasks: Task, messages: TekMessage]

    String toString(){
        "$name, $city" }

    static constraints = {
        name()
        city()
        description maxSize: 5000
        organizer()
        venue()
        startDate()
        endDate()
        volunteers nullable: true
        sponsorships nullable: true
        tasks nullable: true
        messages nullable: true
        nickname nullable: true
    }
}
