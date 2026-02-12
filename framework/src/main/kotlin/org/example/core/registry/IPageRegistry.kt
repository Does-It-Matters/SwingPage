package org.example.core.registry

import org.example.core.intent.IIntent
import org.example.core.page.presentation.AbstractIPage

interface IPageRegistry {
    fun register(intent: IIntent?, page: AbstractIPage?)

    fun get(intent: IIntent?): AbstractIPage?
}
