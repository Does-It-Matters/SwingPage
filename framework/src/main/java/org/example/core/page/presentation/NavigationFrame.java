package org.example.core.page.presentation;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class NavigationFrame extends JFrame {
    private final Deque<AbstractIPage> historyStack = new ArrayDeque<>();
    private final Deque<AbstractIPage> forwardStack = new ArrayDeque<>();
    private final JPanel contents = new JPanel();

    private final JButton prevBtn = new JButton("<");
    private final JButton nextBtn = new JButton(">");

    public NavigationFrame(String title) {
        super(title);
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null); // 화면 중앙 배치

        // 1. 상단 네비게이션 패널
        JPanel navPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        navPanel.setBackground(new Color(245, 245, 245));

        // 버튼에 클릭 이벤트 연결
        prevBtn.addActionListener(e -> previous());
        nextBtn.addActionListener(e -> next());

        navPanel.add(prevBtn);
        navPanel.add(nextBtn);

        // 2. 메인 프레임에 배치
        add(navPanel, BorderLayout.NORTH);

        contents.setLayout(new BorderLayout());
        add(contents, BorderLayout.CENTER);

        setVisible(true);
    }

    public void injectContents(AbstractIPage page) {
        if (!historyStack.isEmpty() && historyStack.peek() == page) {
            return;
        }

        forwardStack.clear();
        historyStack.push(page);

        setContents(page);
    }

    private void next() {
        if (!forwardStack.isEmpty()) {
            AbstractIPage next = forwardStack.pop();
            historyStack.push(next);
            setContents(next);
        }
    }

    private void previous() {
        if (historyStack.size() > 1) {
            AbstractIPage current = historyStack.pop();
            forwardStack.push(current);

            AbstractIPage previous = historyStack.peek();
            setContents(previous);
        }
    }

    private void setContents(AbstractIPage page) {
        JPanel center = page.getPanel();
        setTitle(page.getTitle());
        contents.removeAll(); // 중앙 내용 삭제
        contents.add(center, BorderLayout.CENTER); // 중앙 내용 추가
        renderPage();
    }

    private void renderPage() {
        prevBtn.setEnabled(historyStack.size() > 1);
        nextBtn.setEnabled(!forwardStack.isEmpty());
        contents.revalidate();
        contents.repaint();
    }
}