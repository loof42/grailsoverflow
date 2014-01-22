package fr.isima.grailsoverflow

import groovy.transform.EqualsAndHashCode
import org.codehaus.groovy.grails.web.servlet.mvc.GrailsWebRequest
import org.codehaus.groovy.grails.web.util.WebUtils

@EqualsAndHashCode
class User {
    String displayName
    String realName
    String email
    String website
    String location
    int score = 0
    Date lastVisit = new Date()
    int profileView = 0
    boolean admin = false
    boolean ban = false

    Set favoriteTags = []

    def isOwnerOfQuestion(def question) {
        question.user.email == email
    }
    
    def isOwnerOfAnswer(def answer) {
        answer.user.email == email
    }

    static hasMany = [questions: Question, favoriteTags: Tag]

    static constraints = {
        email blank: false, unique: true
        realName nullable: true
        website nullable: true
        lastVisit blank: false
        location nullable: true
    }
    
    static mapping = {
        questions cascade:"all,delete-orphan"
        favoriteTags lazy: false
    }
}
