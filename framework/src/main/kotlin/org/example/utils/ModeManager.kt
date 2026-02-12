package org.example.utils

import java.awt.Color
import java.awt.Insets
import java.awt.Window
import javax.swing.SwingUtilities
import javax.swing.UIManager

class ModeManager () {
    var state: Mode = Mode.LIGHT

    fun toggle() {
        state = if (state == Mode.DARK) Mode.LIGHT else Mode.DARK
        applyTheme()
    }

    fun applyTheme() {
        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel")

        if (state == Mode.DARK) {
            UIManager.put("control", Color(30, 30, 30))
            UIManager.put("nimbusBase", Color(45, 45, 48))
            UIManager.put("text", Color(204, 204, 204))

            UIManager.put("Button.background", Color(37, 37, 38))
            UIManager.put("nimbusBlueGrey", Color(37, 37, 38))
            UIManager.put("Button.foreground", Color.WHITE)

            UIManager.put("nimbusFocus", Color(100, 100, 100))
            UIManager.put("nimbusSelectionBackground", Color(204, 204, 204))
        } else {
            UIManager.put("control", Color(233, 233, 233))
            UIManager.put("nimbusBase", Color(233, 233, 231))
            UIManager.put("text", Color(0, 0, 0))

            UIManager.put("Button.background", Color(233, 233, 233))
            UIManager.put("nimbusBlueGrey", Color(247, 246, 243))
            UIManager.put("Button.foreground", Color(0, 0, 0))

            UIManager.put("nimbusFocus", Color(35, 131, 226, 100))
            UIManager.put("nimbusSelectionBackground", Color(35, 131, 226, 50))
        }

        UIManager.put("Button.contentMargins", Insets(6, 16, 6, 16))

        for (window in Window.getWindows()) {
            SwingUtilities.updateComponentTreeUI(window)
        }
    }
}