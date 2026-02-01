package org.example.core.page.presentation;

import org.example.core.loader.IEventPublisher;

import javax.swing.*;

public abstract class AbstractIPage {
    private final String title;
    private final AbstractController controller;

    public AbstractIPage(String title, AbstractController controller) {
        this.title = title;
        this.controller = controller;
    }

    public final String getTitle() {
        return title;
    }

    public JPanel getPanel() {
        return controller.getLayout();
    }

    public final void setEventPublisher(IEventPublisher publisher) {
        controller.setEventPublisher(publisher);
    }
}