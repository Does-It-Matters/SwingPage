package org.example.page.task.signin

import org.example.core.page.presentation.AbstractController
import org.example.intent.ExpertUserSignUp
import org.example.intent.GeneralUserSignUp
import org.example.intent.MyPage
import java.awt.Component
import java.awt.Dimension
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.*

internal class Controller(service: Service) : AbstractController(service) {
    override val layout: JPanel
        get() {
            println("why")
            val layout = JPanel()
            layout.setLayout(BoxLayout(layout, BoxLayout.Y_AXIS))
            layout.setBorder(BorderFactory.createEmptyBorder(40, 60, 40, 60))

            val idField = JTextField(20)
            val passwordField = JPasswordField(20)

            val loginButton = JButton("Login")
            val generalUserSignUpButton = JButton("Sign Up as General user")
            val expertUserSignUpButton = JButton("Sign Up as Expert user")

            val components =
                arrayOf<Component>(idField, passwordField, loginButton, generalUserSignUpButton, expertUserSignUpButton)
            val buttonSize = Dimension(250, 35)

            for (comp in components) {
                (comp as JComponent).setAlignmentX(Component.CENTER_ALIGNMENT)
                comp.setMaximumSize(buttonSize)
            }

            loginButton.addActionListener(ActionListener { e: ActionEvent? ->
                onLoginButtonClick(
                    idField.getText(),
                    String(passwordField.getPassword())
                )
            })
            generalUserSignUpButton.addActionListener(ActionListener { e: ActionEvent? -> onGeneralUserSignUpButtonClick() })
            expertUserSignUpButton.addActionListener(ActionListener { e: ActionEvent? -> onExpertUserSignUpButtonClick() })

            layout.add(JLabel("ID"))
            layout.add(idField)
            layout.add(Box.createVerticalStrut(10))

            layout.add(JLabel("Password"))
            layout.add(passwordField)
            layout.add(Box.createVerticalStrut(20))

            layout.add(loginButton)
            layout.add(Box.createVerticalStrut(10))
            layout.add(generalUserSignUpButton)
            layout.add(Box.createVerticalStrut(10))
            layout.add(expertUserSignUpButton)

            return layout
        }

    private fun onLoginButtonClick(id: String?, pw: String?) {
        if (service is Service) {
            (service as Service).login(id, pw)
            System.out.printf("Sign in. ID: %s, pw: %s%n", id, pw)
            dispatcher?.dispatch(MyPage("MyPage"))
        }
    }

    private fun onGeneralUserSignUpButtonClick() {
        println("general user Sign up")
        dispatcher?.dispatch(GeneralUserSignUp("GeneralUserSignUp"))
    }

    private fun onExpertUserSignUpButtonClick() {
        println("expert user Sign up")
        dispatcher?.dispatch(ExpertUserSignUp("ExpertUserSignUp"))
    }
}