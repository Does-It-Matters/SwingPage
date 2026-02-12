package org.example.core.dispatcher

import org.example.core.intent.IIntent
import org.example.core.loader.IPageLoader

interface IPageDispatcher {
    fun register(pageLoader: IPageLoader?)

    fun dispatch(intent: IIntent?)
}
