package org.example.utils;

import javax.swing.*;
import java.awt.*;

public class ModeManager {
    private Mode state = Mode.DARK;

    public void toggle() {
        state = (state == Mode.DARK) ? Mode.LIGHT : Mode.DARK;
        applyTheme();
    }

    public Mode getMode() {
        return state;
    }

    public void applyTheme() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

            if (state == Mode.DARK) {
                UIManager.put("control", new Color(30, 30, 30));
                UIManager.put("nimbusBase", new Color(45, 45, 48));
                UIManager.put("text", new Color(204, 204, 204));

                UIManager.put("Button.background", new Color(37, 37, 38));
                UIManager.put("nimbusBlueGrey", new Color(37, 37, 38));
                UIManager.put("Button.foreground", Color.WHITE);

                UIManager.put("nimbusFocus", new Color(100, 100, 100));
                UIManager.put("nimbusSelectionBackground", new Color(204, 204, 204));

            } else {
                UIManager.put("control", new Color(233, 233, 233));
                UIManager.put("nimbusBase", new Color(233, 233, 231));
                UIManager.put("text", new Color(0, 0, 0));

                UIManager.put("Button.background", new Color(233, 233, 233));
                UIManager.put("nimbusBlueGrey", new Color(247, 246, 243));
                UIManager.put("Button.foreground", new Color(0, 0, 0));

                UIManager.put("nimbusFocus", new Color(35, 131, 226, 100));
                UIManager.put("nimbusSelectionBackground", new Color(35, 131, 226, 50));
            }

            UIManager.put("Button.contentMargins", new Insets(6, 16, 6, 16));

            for (Window window : Window.getWindows()) {
                SwingUtilities.updateComponentTreeUI(window);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

