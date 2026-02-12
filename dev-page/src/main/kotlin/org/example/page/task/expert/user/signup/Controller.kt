package org.example.page.task.expert.user.signup

import org.example.core.page.presentation.AbstractController
import org.example.intent.SignIn
import org.example.page.task.utils.*
import javax.swing.*

internal class Controller(
    private val expertUserService: Service
) : AbstractController(expertUserService) {

    override val layout: JPanel
        get() = panel {

            label("ID:")
            val idField = textField(tooltip = "ID")

            vSpace(10)

            label("Password:")
            val passwordField = passwordField()

            vSpace(20)

            button("Sign Up") {
                onSignUpButtonClick(
                    idField.text,
                    String(passwordField.password)
                )
            }

            vSpace(10)

            button("Home") {
                onHomeButtonClick()
            }
        }

    private fun onSignUpButtonClick(id: String, pw: String) {
        if (id.isBlank() || pw.isBlank()) {
            alert()
            return
        }

        expertUserService.signUp(id, pw)
        println("Expert User Sign up. ID: $id, pw: $pw")

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
