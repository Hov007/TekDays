import com.tekdays.*

class BootStrap {
    TaskService taskService

    def init = { servletContext ->
//        if (!TekUser.get(1)) {
//            TekUser.withTransaction {
//                new TekUser(
//                        fullName: 'John Doe',
//                        userName: 'jdoe',
//                        password: 'jdoe',
//                        email: 'jdoe@johnsgroovyshop.com',
//                        website: 'blog.johnsgroovyshop.com',
//                        bio: '''John has been programming for over 40 years. He has
//worked with every programming language known to man
//and has settled on Groovy. In his spare time, John
//dabbles in astro physics and plays
//shuffleboard.''').save()
//
//                new TekUser(
//                        fullName: 'John Deere',
//                        userName: 'tractorman',
//                        password: 't0ps3cr3t',
//                        email: 'john.deere@porkproducers.org',
//                        website: 'www.perl.porkproducers.org',
//                        bio: '''John is a top notch Perl programmer and a pretty
//good hand around the farm. If he can't program it he
//can plow it!''').save()
//
//                def event1 = new TekEvent(name: 'Gateway Code Camp',
//                        city: 'Saint Louis, MO',
//                        organizer: TekUser.findByFullName('John Doe'),
//                        venue: 'TBD',
//                        startDate: new Date('11/21/2013'),
//                        endDate: new Date('11/21/2013'),
//                        description: '''This conference will bring coders from
//across platforms, languages, and industries
//together for an exciting day of tips, tricks,
//and tech! Stay sharp! Stay at the top of your
//game! But, don't stay home! Come an join us
//this fall for the first annual Gateway Code
//Camp.''').save()
//                if (!event1.save()) {
//                    event1.errors.allErrors.each { error ->
//                        println "An error occured with event1: ${error}"
//                    }
//                }
//                taskService.addDefaultTasks(event1)
//            }
//
//        }
//

    }
    def destroy = {}
}
