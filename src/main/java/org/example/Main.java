package org.example;

import org.example.core.page.cookie.ICookie;
import org.example.event.ExpertUserSignUpEvent;
import org.example.event.GeneralUserSignUpEvent;
import org.example.event.MyPageEvent;
import org.example.event.SignInEvent;
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
            JFrame mainFrame = new JFrame("Q&A Client");

            // 2. 공통 자원(Cookie 등) 초기화
            ICookie cookie = new Cookie();

            // 3. PageLoader 구성
            var pageLoader = PageLoaderProvider.builder()
                    .register(new ExpertUserSignUpEvent(), InjectorExpertUserSignUp.getPage())
                    .register(new GeneralUserSignUpEvent(), InjectorGeneralUserSignUp.getPage())
                    .register(new SignInEvent(), InjectorSignIn.getPage(cookie))
                    .register(new MyPageEvent(), InjectorMyPage.getPage(cookie))
                    .build()
                    .getPageLoader();

            // 4. 어플리케이션 시작
            pageLoader.start(mainFrame, new SignInEvent());
        });
    }
}