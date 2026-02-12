package org.example.core.page.presentation

import org.example.core.dispatcher.IIntentDispatcher
import org.example.core.page.application.AbstractService
import javax.swing.JPanel

abstract class AbstractController {
    protected val service: AbstractService?
    protected var dispatcher: IIntentDispatcher? = null

    // 레이어드 아키텍처를 적용하는 경우
    constructor(service: AbstractService) {
        this.service = service
    }

    // 레이어드 아키텍처를 적용하지 않고 자유도를 높인 경우
    constructor() {
        this.service = null
    }

    fun setIntentDispatcher(dispatcher: IIntentDispatcher?) {
        this.dispatcher = dispatcher
    }

    abstract val layout: JPanel?
}