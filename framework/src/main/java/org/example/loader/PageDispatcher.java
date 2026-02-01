package org.example.loader;

import org.example.core.intent.IIntent;
import org.example.core.dispatcher.IPageDispatcher;
import org.example.core.loader.IPageLoader;

class PageDispatcher implements IPageDispatcher {
    private IPageLoader pageLoader;

    @Override
    public void register(IPageLoader pageLoader) {
        this.pageLoader = pageLoader;
    }

    @Override
    public void dispatch(IIntent intent) {
        pageLoader.show(intent);
    }
}
