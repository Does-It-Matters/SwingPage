package org.example.page.cookie

import org.example.core.page.cookie.ICookie
import org.example.page.cookie.store.Role

class Cookie : ICookie, Role {
    override var id: String? = null
    override var role: String? = null
}
