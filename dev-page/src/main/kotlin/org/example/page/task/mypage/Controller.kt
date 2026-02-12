package org.example.page.task.mypage

import org.example.core.page.presentation.AbstractController
import org.example.intent.SignIn
import java.awt.*
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.*

internal class Controller(service: Service) : AbstractController(service) {
    override val layout: JPanel
        get() {
            val layout = JPanel()
            layout.setLayout(BoxLayout(layout, BoxLayout.Y_AXIS))
            layout.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40))

            var idText: String? = "ID: "
            var roleText: String? = "ROLE: "

            if (service is Service) {
                val myProfile: MyProfile = (service as Service).myProfile
                idText += myProfile.id
                roleText += myProfile.role
            }

            val idLabel = JLabel(idText)
            val roleLabel = JLabel(roleText)
            val logoutButton = JButton("Log Out")

            idLabel.setAlignmentX(Component.CENTER_ALIGNMENT)
            roleLabel.setAlignmentX(Component.CENTER_ALIGNMENT)
            logoutButton.setAlignmentX(Component.CENTER_ALIGNMENT)

            idLabel.setFont(Font("SansSerif", Font.BOLD, 14))
            roleLabel.setFont(Font("SansSerif", Font.PLAIN, 14))

            logoutButton.addActionListener(ActionListener { e: ActionEvent? -> onLogoutButtonClick() })

            layout.add(idLabel)
            layout.add(Box.createVerticalStrut(10))
            layout.add(roleLabel)
            layout.add(Box.createVerticalStrut(30)) // 로그아웃 버튼 전 더 넓은 간격
            layout.add(logoutButton)

            return layout
        }

    /**
     * ** 역할: 로그아웃 **
     */
    private fun onLogoutButtonClick() {
        println("logout")
        dispatcher?.dispatch(SignIn("SignIn"))
    }
}