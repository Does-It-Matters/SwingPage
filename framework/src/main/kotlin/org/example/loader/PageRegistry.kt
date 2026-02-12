package org.example.loader

import org.example.core.intent.IIntent
import org.example.core.page.presentation.AbstractIPage
import org.example.core.registry.IPageRegistry

internal class PageRegistry: IPageRegistry {
    private val pages: MutableMap<IIntent?, AbstractIPage?> = HashMap()

    override fun register(
        intent: IIntent?,
        page: AbstractIPage?
    ) {
        pages[intent] = page
    }

    override fun get(intent: IIntent?): AbstractIPage? {
        return pages[intent]
    }
}