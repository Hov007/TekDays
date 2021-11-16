package com.tekdays

import org.hibernate.envers.Audited

@Audited
class Sponsorship {

    TekEvent event
    Sponsor sponsor
    String contributionType
    String description
    String notes

//    String toString() {
//      return  "Event: ${event.name}, Sponsor: $sponsor"
//    }

    static constraints = {
        event nullable: false
        sponsor nullable: false
        contributionType inList: ["Other", "Venue", "A/V", "Promotion", "Cash"]
        description nullable: true, blank: true
        notes nullable: true, maxSize: 5000
    }


}
