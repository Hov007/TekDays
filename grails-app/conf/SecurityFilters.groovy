class SecurityFilters {
    def filters = {
        doLogin(controller: "*", action: "*") {
            before = {
                if (!controllerName)
                    return true
                def allowedActions = ['show', 'index', 'login', 'validate']

                if (!session.user && !allowedActions.contains(actionName) ||
                        !session.user && controllerName == 'tekMessage' ) {
                    redirect(controller: 'tekUser', action: 'login',
                            params: ['cName': controllerName, 'aName': actionName, 'id':params.id])
                    return false
                }

            }
        }
    }
}