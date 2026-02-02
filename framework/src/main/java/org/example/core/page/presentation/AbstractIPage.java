package org.example.core.page.presentation;

import org.example.core.dispatcher.IIntentDispatcher;

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

    public final void setIntentDispatcher(IIntentDispatcher dispatcher) {
        controller.setIntentDispatcher(dispatcher);
    }
}