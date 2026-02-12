package org.example.page.task.general.user.signup

import org.example.core.page.presentation.AbstractIPage

object AssemblerGeneralUserSignUp {
    val page: AbstractIPage
        get() {
            val request: Request = Request()
            val service: Service = Service(request)
            val controller: Controller = Controller(service)
            return Page(controller)
        }
}
