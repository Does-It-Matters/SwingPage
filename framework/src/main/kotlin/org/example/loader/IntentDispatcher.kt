package org.example.loader

import org.example.core.dispatcher.IIntentDispatcher
import org.example.core.dispatcher.IPageDispatcher
import org.example.core.intent.IIntent

internal class IntentDispatcher(private val dispatcher: IPageDispatcher) : IIntentDispatcher {

    override fun dispatch(intent: IIntent?) {
        dispatcher.dispatch(intent)
    }
}
