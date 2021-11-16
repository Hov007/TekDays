package com.tekdays

import org.hibernate.envers.Audited

@Audited
class TekMessage {

    String subject
    String content
    TekMessage parent
    TekEvent event
    TekUser author

    String toString() {
        "Subject: $subject, Author: $author"
    }

    static constraints = {
        subject blank: false
        content blank: false, maxSize: 5000
        parent nullable: true
        author nullable: false
    }
    static belongsTo = TekEvent
}
