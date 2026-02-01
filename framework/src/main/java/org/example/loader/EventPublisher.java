package org.example.loader;

import org.example.core.event.IEvent;
import org.example.core.loader.IEventPublisher;
import org.example.core.loader.IPageEventBus;

class EventPublisher implements IEventPublisher {
    private final IPageEventBus eventBus;

    EventPublisher(IPageEventBus eventBus) {
        this.eventBus = eventBus;
    }

    @Override
    public void publish(IEvent event) {
        eventBus.publish(event);
    }
}
