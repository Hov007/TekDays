package com.tekdays

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(TekUser)
class TekUserSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test toString"() {
        when: "a tekUser has a fullName"
        def tekUser = new TekUser(fullName: 'James Bond')
        then: "the toString method will show"
        tekUser.toString() == 'James Bond'
    }
}
