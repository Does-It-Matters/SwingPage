package org.example.loader;

import org.example.core.intent.IIntent;
import org.example.core.loader.IPageLoader;
import org.example.core.registry.IPageRegistry;
import org.example.core.page.presentation.AbstractIPage;
import org.example.core.page.presentation.NavigationFrame;

class IntentDrivenPageLoader implements IPageLoader {
    private final IPageRegistry pageRegistry;
    private NavigationFrame frame;

    IntentDrivenPageLoader(IPageRegistry pageRegistry) {
        this.pageRegistry = pageRegistry;
    }

    @Override
    public void start(NavigationFrame mainFrame, IIntent intent) {
        this.frame = mainFrame;
        show(intent);
    }

    @Override
    public void show(IIntent intent) {
        AbstractIPage page = pageRegistry.get(intent);
        if (page == null)
            return;

        frame.injectContents(page);
    }
}