package org.example.core.loader;

import org.example.core.event.IEvent;
import org.example.core.page.presentation.AbstractIPage;

public interface IPageRegistry {
    void register(IEvent event, AbstractIPage page);
    AbstractIPage get(IEvent event);
}