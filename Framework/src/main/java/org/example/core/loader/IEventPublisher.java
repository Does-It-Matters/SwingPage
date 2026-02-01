package org.example.core.loader;

import org.example.core.event.IEvent;

public interface IEventPublisher {
    void publish(IEvent pageType);
}
