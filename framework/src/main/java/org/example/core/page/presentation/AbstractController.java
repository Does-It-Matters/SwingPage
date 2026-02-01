package org.example.core.page.presentation;

import org.example.core.dispatcher.IIntentDispatcher;
import org.example.core.page.application.AbstractService;

import javax.swing.*;

public abstract class AbstractController {
    protected final AbstractService service;
    protected IIntentDispatcher dispatcher;

    // 레이어드 아키텍처를 적용하는 경우
    public AbstractController(AbstractService service) {
        this.service = service;
    }

    // 레이어드 아키텍처를 적용하지 않고 자유도를 높인 경우
    public AbstractController() {
        this.service = null;
    }

    public final void setIntentDispatcher(IIntentDispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    public abstract JPanel getLayout();
}