package org.example.core.loader;

import org.example.core.intent.IIntent;
import org.example.core.page.presentation.NavigationFrame;

public interface IPageLoader {

    /**
     * 어플리케이션을 시작하고 초기 화면을 표시합니다.
     *
     * @param mainFrame 어플리케이션의 메인 윈도우
     * @param intent 초기 표시할 페이지에 대한 의도
     */
    void start(NavigationFrame mainFrame, IIntent intent);

    /**
     * 전달된 Intent에 따라 페이지를 전환합니다.
     *
     * @param intent 전환할 페이지를 식별하는 의도
     */
    void show(IIntent intent);
}
