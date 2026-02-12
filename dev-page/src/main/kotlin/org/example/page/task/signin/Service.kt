package org.example.page.task.signin

import org.example.core.page.application.AbstractService
import org.example.core.page.cookie.ICookie
import org.example.page.cookie.store.Role

internal class Service(private val request: Request, cookie: ICookie?) : AbstractService(cookie) {
    fun login(id: String?, password: String?) {
        request.login(EntityUser(id, password))

        // cookie를 Role로 안전하게 형변환한 뒤, 성공(null이 아님)하면 실행
        (cookie as? Role)?.apply {
            this.id = id
            this.role = "temporary"
        }
    }
}