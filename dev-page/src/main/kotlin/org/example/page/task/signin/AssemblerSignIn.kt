package org.example.page.task.signin

import org.example.core.page.cookie.ICookie
import org.example.core.page.presentation.AbstractIPage

object AssemblerSignIn {
    fun getPage(cookie: ICookie?): AbstractIPage {
        val request = Request()
        val service = Service(request, cookie)
        val controller = Controller(service)
        return Page(controller)
    }
}
