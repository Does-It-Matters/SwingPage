package org.example.core.dispatcher

import org.example.core.intent.IIntent

interface IIntentDispatcher {
    fun dispatch(intent: IIntent?)
}
