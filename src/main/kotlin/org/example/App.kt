package org.example

import org.example.core.loader.IPageLoader
import org.example.core.page.cookie.ICookie
import org.example.core.page.presentation.NavigationFrame
import org.example.intent.ExpertUserSignUp
import org.example.intent.GeneralUserSignUp
import org.example.intent.MyPage
import org.example.intent.SignIn
import org.example.loader.PageLoaderProvider
import org.example.page.cookie.Cookie
import org.example.page.task.expert.user.signup.AssemblerExpertUserSignUp
import org.example.page.task.general.user.signup.AssemblerGeneralUserSignUp
import org.example.page.task.mypage.AssemblerMyPage
import org.example.page.task.signin.AssemblerSignIn
import javax.swing.JButton
import javax.swing.SwingUtilities

fun main() {
    SwingUtilities.invokeLater(Runnable {
        // 1. 싱글 윈도우 생성
        val mainFrame: NavigationFrame = NavigationFrame("Q&A Client")
        mainFrame.addMenu(JButton("커스텀 1"))
        mainFrame.addMenu(JButton("커스텀 2"))
        mainFrame.addMenu(JButton("커스텀 3"))

        // 2. 공통 자원(Cookie 등) 초기화
        val cookie: ICookie = Cookie()

        // 3. PageLoader 구성
        val pageLoader: IPageLoader? =
            PageLoaderProvider.builder()
                .register(ExpertUserSignUp("ExpertUserSignUp"), AssemblerExpertUserSignUp.page)
                .register(GeneralUserSignUp("GeneralUserSignUp"), AssemblerGeneralUserSignUp.page)
                .register(SignIn("SignIn"), AssemblerSignIn.getPage(cookie))
                .register(MyPage("MyPage"), AssemblerMyPage.getPage(cookie))
                .build()
                .getPageLoader()

        // 4. 어플리케이션 시작
        pageLoader?.start(mainFrame, SignIn("SignIn"))
    })
}