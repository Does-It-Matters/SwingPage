package org.example.loader;

import org.example.core.intent.IIntent;
import org.example.core.dispatcher.IIntentDispatcher;
import org.example.core.dispatcher.IPageDispatcher;

class IntentDispatcher implements IIntentDispatcher {
    private final IPageDispatcher dispatcher;

    IntentDispatcher(IPageDispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    @Override
    public void dispatch(IIntent intent) {
        dispatcher.dispatch(intent);
    }
}
