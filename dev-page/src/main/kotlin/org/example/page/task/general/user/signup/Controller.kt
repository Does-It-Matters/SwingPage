package org.example.page.task.general.user.signup

import org.example.core.page.presentation.AbstractController
import org.example.intent.SignIn
import java.awt.Dimension
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.*

internal class Controller(private val generalUserService: Service) : AbstractController(generalUserService) {
    override val layout: JPanel
        get() {
            val layout = JPanel()
            layout.setLayout(BoxLayout(layout, BoxLayout.Y_AXIS))
            layout.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20))

            val idField = JTextField(20)
            idField.maximumSize = Dimension(Int.Companion.MAX_VALUE, 30)
            idField.setToolTipText("ID")

            val passwordField = JPasswordField(20)
            passwordField.maximumSize = Dimension(Int.Companion.MAX_VALUE, 30)

            val signUpButton = JButton("Sign Up")
            val homeButton = JButton("Home")

            signUpButton.addActionListener(ActionListener { e: ActionEvent? ->
                onSignUpButtonClick(
                    idField.getText(),
                    String(passwordField.getPassword())
                )
            })
            homeButton.addActionListener(ActionListener { e: ActionEvent? -> onHomeButtonClick() })

            layout.add(JLabel("ID:"))
            layout.add(idField)
            layout.add(Box.createVerticalStrut(10))
            layout.add(JLabel("Password:"))
            layout.add(passwordField)
            layout.add(Box.createVerticalStrut(20))
            layout.add(signUpButton)
            layout.add(Box.createVerticalStrut(10))
            layout.add(homeButton)

            return layout
        }

    private fun onSignUpButtonClick(id: String, pw: String) {
        if (id.isEmpty() || pw.isEmpty()) {
            alert()
            return
        }

        generalUserService.signUp(id, pw)
        System.out.printf("Expert User Sign up. ID: %s, pw: %s%n", id, pw)
        dispatcher?.dispatch(SignIn("SignIn"))
    }

    private fun alert() {
        JOptionPane.showMessageDialog(
            null,
            "Please fill out all fields.",
            "Sign Up Error",
            JOptionPane.WARNING_MESSAGE
        )
    }

    private fun onHomeButtonClick() {
        dispatcher?.dispatch(SignIn("SignIn"))
        println("Go Home")
    }
}