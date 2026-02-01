package org.example.loader;

import org.example.core.intent.IIntent;
import org.example.core.loader.IPageLoader;
import org.example.core.page.presentation.AbstractIPage;

public class PageLoaderProvider {
    public static class PageLoaderBuilder {
        private final PageDispatcher pageDispatcher = new PageDispatcher();
        private final IntentDispatcher intentDispatcher = new IntentDispatcher(pageDispatcher);
        private final PageRegistry registry = new PageRegistry();

        public PageLoaderBuilder register(IIntent intent, AbstractIPage page) {
            page.setEventPublisher(intentDispatcher);
            registry.register(intent, page);
            return this;
        }

        public PageLoaderProvider build() {
            var pageLoader = new IntentDrivenPageLoader(registry);
            pageDispatcher.register(pageLoader);
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
