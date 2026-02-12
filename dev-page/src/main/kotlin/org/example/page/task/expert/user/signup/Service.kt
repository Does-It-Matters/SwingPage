package org.example.page.task.expert.user.signup

import org.example.core.page.application.AbstractService

internal class Service(private val request: Request): AbstractService() {
    fun signUp(id: String?, password: String?) {
        request.signUp(EntityExpertUser(id, password))
    }
}
