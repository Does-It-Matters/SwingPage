package org.example;

import org.example.core.page.cookie.ICookie;
import org.example.core.page.presentation.NavigationFrame;
import org.example.intent.ExpertUserSignUp;
import org.example.intent.GeneralUserSignUp;
import org.example.intent.MyPage;
import org.example.intent.SignIn;
import org.example.loader.PageLoaderProvider;
import org.example.page.cookie.Cookie;
import org.example.page.task.expert.user.signup.InjectorExpertUserSignUp;
import org.example.page.task.general.user.signup.InjectorGeneralUserSignUp;
import org.example.page.task.mypage.InjectorMyPage;
import org.example.page.task.signin.InjectorSignIn;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // 1. 싱글 윈도우 생성
            NavigationFrame mainFrame = new NavigationFrame("Q&A Client");
            mainFrame.addMenu(new JButton("커스텀 1"));
            mainFrame.addMenu(new JButton("커스텀 2"));
            mainFrame.addMenu(new JButton("커스텀 3"));

            // 2. 공통 자원(Cookie 등) 초기화
            ICookie cookie = new Cookie();

            // 3. PageLoader 구성
            var pageLoader = PageLoaderProvider.builder()
                    .register(new ExpertUserSignUp(), InjectorExpertUserSignUp.getPage())
                    .register(new GeneralUserSignUp(), InjectorGeneralUserSignUp.getPage())
                    .register(new SignIn(), InjectorSignIn.getPage(cookie))
                    .register(new MyPage(), InjectorMyPage.getPage(cookie))
                    .build()
                    .getPageLoader();

            // 4. 어플리케이션 시작
            pageLoader.start(mainFrame, new SignIn());
        });
    }
}