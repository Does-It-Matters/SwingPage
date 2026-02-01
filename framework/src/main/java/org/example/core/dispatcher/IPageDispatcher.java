package org.example.core.dispatcher;

import org.example.core.intent.IIntent;
import org.example.core.loader.IPageLoader;

public interface IPageDispatcher {
    void register(IPageLoader pageLoader);

    void dispatch(IIntent intent);
}
