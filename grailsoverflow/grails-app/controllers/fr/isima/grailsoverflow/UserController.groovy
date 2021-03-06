package fr.isima.grailsoverflow

class UserController {

    def userService
    def sessionService

    def show() {
        // Call userService to get the user corresponding to params.id
        User user = userService.getUserById(params.id)

        if (user.email != session.user?.email) {
            userService.addProfileVisit(user);
        }

        if(user == null) {
            // Error user not found
            redirect(controller: "question", action: "index")
        }

        def userHistory = userService.getUserHistory(user, AppConfig.HISTORY)

        return [user: user, userHistory: userHistory]
    }

    def edit() {
        // Call userService to get the user corresponding to params.id
        User user = userService.getUserById(params.id)

        if(session.user == null ||( session.user.email != user?.email && session.user.admin == false )) {
            sessionService.addMessage("danger", "grow.error.access.forbidden")
            log.warn "WARNING : Address ${request.getRemoteAddr()} try to edit user ${params.id} but do not have rights"
            redirect(controller: "question", action: "index")
        }

        return [user: user]
    }

    def ban() {
        User user = userService.getUserById(params.id)
        def textButton
        // Auto-ban impossible
        if(session.user == null || session.user.admin == false || user.id == session.user.id ) {
            sessionService.addMessage("danger", "grow.error.access.forbidden")
            log.warn "WARNING : Address ${request.getRemoteAddr()} try to ban user ${params.id} but do not have rights"
            redirect(controller: "question", action: "index")
        }
        if(!user.ban)
        {
            textButton="Unban"
            userService.banUser(params.id)
        }
        else
        {
            textButton="Ban"
            userService.unbanUser(params.id)
        }

        render(text:textButton, contentType:'text/html')
    }

    // Post call by form
    def editInfo() {
        if(session.user == null || (params.id.equals(session.user.id) && session.user.admin == false)) {
            sessionService.addMessage("danger", "grow.error.access.forbidden")
            log.warn "WARNING : Address ${request.getRemoteAddr()} try to edit user ${params.id} but do not have rights"
            redirect(controller: "question", action: "index")
        } else {
            userService.updateUser(params.id, params.displayName, params.website, params.location, params.tags)
            redirect(controller: "user", action: "show", id: params.id )
        }
    }


}
