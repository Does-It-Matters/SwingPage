package org.example.core.loader;

import org.example.core.event.IEvent;
import org.example.core.page.presentation.NavigationFrame;

public interface IPageLoader {
    /**
     * 어플리케이션을 시작하고 초기 화면을 표시합니다.
     * * @param mainFrame 어플리케이션의 메인 윈도우
     * @param event 초기 표시할 페이지 정보를 담은 이벤트
     */
    void start(NavigationFrame mainFrame, IEvent event);

    /**
     * 특정 이벤트에 해당하는 페이지로 화면을 전환합니다.
     * * @param event 전환할 페이지의 타입을 식별하는 이벤트
     */
    void show(IEvent event);
}