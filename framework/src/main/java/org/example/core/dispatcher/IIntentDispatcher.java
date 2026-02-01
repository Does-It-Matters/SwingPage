package org.example.core.dispatcher;

import org.example.core.intent.IIntent;

public interface IIntentDispatcher {
    void dispatch(IIntent intent);
}
