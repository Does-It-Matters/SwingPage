package org.example.page.task.expert.user.signup

import org.example.core.page.presentation.AbstractIPage

object AssemblerExpertUserSignUp {
    val page: AbstractIPage
        get() {
            val request: Request = Request()
            val service: Service = Service(request)
            val controller: Controller = Controller(service)
            return Page(controller)
        }
}
