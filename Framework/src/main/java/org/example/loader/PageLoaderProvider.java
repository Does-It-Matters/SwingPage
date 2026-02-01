package org.example.loader;

import org.example.core.event.IEvent;
import org.example.core.loader.IPageLoader;
import org.example.core.page.presentation.AbstractIPage;

public class PageLoaderProvider {
    public static class PageLoaderBuilder {
        private final PageEventBus eventBus = new PageEventBus();
        private final EventPublisher publisher = new EventPublisher(eventBus);
        private final PageRegistry registry = new PageRegistry();

        public PageLoaderBuilder register(IEvent event, AbstractIPage page) {
            page.setEventPublisher(publisher);
            registry.register(event, page);
            return this;
        }

        public PageLoaderProvider build() {
            var pageLoader = new PageLoaderWithEventListener(registry);
            eventBus.register(pageLoader);
            return new PageLoaderProvider(pageLoader);
        }
    }

    private final IPageLoader pageLoader;

    private PageLoaderProvider(IPageLoader pageLoader) {
        this.pageLoader = pageLoader;
    }

    public static PageLoaderBuilder builder() {
        return new PageLoaderBuilder();
    }

    public IPageLoader getPageLoader() {
        return pageLoader;
    }
}
