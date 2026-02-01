package org.example.loader;

import org.example.core.event.IEvent;
import org.example.core.loader.IEventListener;
import org.example.core.loader.IPageLoader;
import org.example.core.loader.IPageRegistry;
import org.example.core.page.presentation.AbstractIPage;

import javax.swing.*;

class PageLoaderWithEventListener implements IPageLoader, IEventListener {
    private final IPageRegistry pageRegistry;
    private JFrame frame;
    private int width;
    private int height;

    PageLoaderWithEventListener(IPageRegistry pageRegistry) {
        this.pageRegistry = pageRegistry;
        this.width = 500;
        this.height = 400;
    }

    @Override
    public void start(JFrame mainFrame, IEvent event) {
        this.frame = mainFrame;

        this.frame.setSize(width, height);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setLocationRelativeTo(null); // 화면 중앙 배치

        show(event);
    }

    @Override
    public void show(IEvent event) {
        // 1. 이벤트에 해당하는 페이지를 가져옴
        AbstractIPage page = pageRegistry.get(event);

        // 2. JFrame의 컨텐츠를 교체
        frame.getContentPane().removeAll();
        frame.getContentPane().add(page.getPanel());

        // 3. 페이지 정보 반영
        frame.setTitle(page.getTitle());

        // 4. Swing 화면 갱신
        frame.revalidate();
        frame.repaint();

        if (!frame.isVisible()) {
            frame.setVisible(true);
        }
    }
}