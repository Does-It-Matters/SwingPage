package org.example.core.loader;

import org.example.core.event.IEvent;

public interface IPageEventBus {
    void register(IPageLoader pageNavigator);
    void publish(IEvent pageType);
}
