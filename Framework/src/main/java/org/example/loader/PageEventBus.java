package org.example.loader;

import org.example.core.event.IEvent;
import org.example.core.loader.IPageEventBus;
import org.example.core.loader.IPageLoader;

class PageEventBus implements IPageEventBus {
    private IPageLoader pageLoader;

    @Override
    public void register(IPageLoader pageLoader) {
        this.pageLoader = pageLoader;
    }

    @Override
    public void publish(IEvent event) {
        pageLoader.show(event);
    }
}
