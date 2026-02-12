package org.example.core.page.application

import org.example.core.page.cookie.ICookie

abstract class AbstractService {
    protected var cookie: ICookie?

    constructor(cookie: ICookie?) {
        this.cookie = cookie
    }

    constructor() {
        this.cookie = null
    }
}
