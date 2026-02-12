package org.example.page.task.general.user.signup

import org.example.core.page.application.AbstractService

internal class Service(private val request: Request): AbstractService() {
    fun signUp(id: String?, password: String?) {
        request.signUp(EntityGeneralUser(id, password))
    }
}
