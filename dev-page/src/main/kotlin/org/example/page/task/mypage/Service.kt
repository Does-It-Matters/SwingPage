package org.example.page.task.mypage

import org.example.core.page.application.AbstractService
import org.example.core.page.cookie.ICookie
import org.example.page.cookie.store.Role

internal class Service(private val request: Request, cookie: ICookie?) : AbstractService(cookie) {
    val myProfile: MyProfile
        get() {
            (cookie as? Role)?. run {
                request.getMyProfile(this.id)
                return MyProfile(this.id, this.role)
            }
            return MyProfile("default", "default")
        }
}
