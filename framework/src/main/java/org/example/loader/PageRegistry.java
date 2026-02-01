package org.example.loader;

import org.example.core.event.IEvent;
import org.example.core.loader.IPageRegistry;
import org.example.core.page.presentation.AbstractIPage;

import java.util.HashMap;
import java.util.Map;

class PageRegistry implements IPageRegistry {
    private final Map<IEvent, AbstractIPage> pages = new HashMap<>();

    @Override
    public void register(IEvent event, AbstractIPage page) {
        pages.put(event, page);
    }

    @Override
    public AbstractIPage get(IEvent event) {
        return pages.get(event);
    }
}