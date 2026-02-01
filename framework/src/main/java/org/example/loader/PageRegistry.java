package org.example.loader;

import org.example.core.intent.IIntent;
import org.example.core.registry.IPageRegistry;
import org.example.core.page.presentation.AbstractIPage;

import java.util.HashMap;
import java.util.Map;

class PageRegistry implements IPageRegistry {
    private final Map<IIntent, AbstractIPage> pages = new HashMap<>();

    @Override
    public void register(IIntent intent, AbstractIPage page) {
        pages.put(intent, page);
    }

    @Override
    public AbstractIPage get(IIntent intent) {
        return pages.get(intent);
    }
}