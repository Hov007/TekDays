package com.tekdays

import org.hibernate.envers.Audited

@Audited
class TekUser {

    String fullName
    String userName
    String password
    String email
    String website
    String bio

    String toString() { fullName }

    static constraints = {
        fullName()
        userName()
        email()
        website nullable: true
        bio maxSize: 5000, nullable: true
    }
}
