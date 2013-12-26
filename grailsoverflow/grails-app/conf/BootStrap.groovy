
import fr.isima.grailsoverflow.Question
import fr.isima.grailsoverflow.Tag
import fr.isima.grailsoverflow.User
import fr.isima.grailsoverflow.Vote

class BootStrap {

    def init = { servletContext ->
        User admin = new User(email: "kevin.renella@gmail.com", displayName: "kevin.renella@gmail.com").save(failOnError: true)
        
        Tag groovy = new Tag(name: "groovy").save(failOnError: true)
        Tag unused = new Tag(name: "unused").save(failOnError: true)
        Tag grails = new Tag(name: "grails").save(failOnError: true)
        Tag jenkins = new Tag(name: "jenkins").save(failOnError: true)
        
        def question = new Question(
            title: "How to create a simple Controller in Groovy ?",
            content: "Hi,\n\
                      I would like to know how to create a simple Controller in Groovy\n\
                      \n\
                      Thanks.",
            dateCreated: new Date(),
            status: "Accepted",
            user: admin
        )
        question.addToTags(groovy)
        question.save(failOnError: true)
        
        question = new Question(
            title: "Is Groovy a good way deploy a web app ?",
            content: "Hi,\n\
                      I would like to know if groovy was a good way to deploy a web app\n\
                      \n\
                      Thanks.",
            dateCreated: new Date(),
            status: "Unanswered",
            user: admin
        )
        question.addToTags(groovy)
        question.save(failOnError: true)
        
        question = new Question(
            title: "What's the best coutinuous integration solution to deploy a grails application ?",
            content: "Hi,\n\
                      I would like to know what's the best coutinuous integration solution to deploy a grails application\n\
                      \n\
                      Thanks.",
            dateCreated: new Date(),
            status: "Unanswered",
            user: admin
        )
        question.addToTags(jenkins)
        question.addToTags(grails)
        question.save(failOnError: true)
        
        question = new Question(
            title: "Is a template difficult to implement in Grails ?",
            content: "Hi, \n\
                      I would like to know if it is difficult to implement a template in grails\n\
                      \n\
                      Thanks.",
            dateCreated: new Date(),
            status: "Unanswered",
            user: admin
        )
        question.addToTags(grails)
        question.save(failOnError: true)
    }
    def destroy = {
    }
}
