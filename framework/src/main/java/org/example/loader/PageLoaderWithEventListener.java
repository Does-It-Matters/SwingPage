package org.example.loader;

import org.example.core.event.IEvent;
import org.example.core.loader.IEventListener;
import org.example.core.loader.IPageLoader;
import org.example.core.loader.IPageRegistry;
import org.example.core.page.presentation.AbstractIPage;
import org.example.core.page.presentation.NavigationFrame;

class PageLoaderWithEventListener implements IPageLoader, IEventListener {
    private final IPageRegistry pageRegistry;
    private NavigationFrame frame;

    PageLoaderWithEventListener(IPageRegistry pageRegistry) {
        this.pageRegistry = pageRegistry;
    }

    @Override
    public void start(NavigationFrame mainFrame, IEvent event) {
        this.frame = mainFrame;
        show(event);
    }

    @Override
    public void show(IEvent event) {
        AbstractIPage page = pageRegistry.get(event);
        if (page == null)
            return;

        frame.injectContents(page);
    }
}