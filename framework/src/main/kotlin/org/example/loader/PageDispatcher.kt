package org.example.loader

import org.example.core.dispatcher.IPageDispatcher
import org.example.core.intent.IIntent
import org.example.core.loader.IPageLoader

internal class PageDispatcher : IPageDispatcher {
    private var pageLoader: IPageLoader? = null

    override fun register(pageLoader: IPageLoader?) {
        this.pageLoader = pageLoader
    }

    override fun dispatch(intent: IIntent?) {
        pageLoader?.show(intent)
    }
}
