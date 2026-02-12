package org.example.utils

import java.awt.*
import javax.swing.*

fun panel(
    axis: Int = BoxLayout.Y_AXIS,
    padding: Int = 20,
    block: JPanel.() -> Unit
): JPanel =
    JPanel().apply {
        layout = BoxLayout(this, axis)
        border = BorderFactory.createEmptyBorder(padding, padding, padding, padding)
        block()
    }

fun JPanel.label(text: String) {
    add(JLabel(text))
}

fun JPanel.textField(
    columns: Int = 20,
    tooltip: String? = null,
    block: JTextField.() -> Unit = {}
): JTextField =
    JTextField(columns).apply {
        maximumSize = Dimension(Int.MAX_VALUE, 30)
        tooltip?.let { toolTipText = it }
        block()
        this@textField.add(this)
    }

fun JPanel.passwordField(
    columns: Int = 20,
    block: JPasswordField.() -> Unit = {}
): JPasswordField =
    JPasswordField(columns).apply {
        maximumSize = Dimension(Int.MAX_VALUE, 30)
        block()
        this@passwordField.add(this)
    }

fun JPanel.button(
    text: String,
    onClick: () -> Unit
) {
    add(JButton(text).apply {
        addActionListener { onClick() }
    })
}

fun JPanel.vSpace(height: Int) {
    add(Box.createVerticalStrut(height))
}
