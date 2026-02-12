package org.example.page.task.mypage

import org.example.core.page.cookie.ICookie
import org.example.core.page.presentation.AbstractIPage

object AssemblerMyPage {
    fun getPage(cookie: ICookie?): AbstractIPage {
        val request = Request()
        val service = Service(request, cookie)
        val controller = Controller(service)
        return Page(controller)
    }
}
