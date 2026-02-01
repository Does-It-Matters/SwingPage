package org.example.page.task.expert.user.signup;

import org.example.core.page.presentation.AbstractController;
import org.example.intent.SignIn;

import javax.swing.*;
import java.awt.*;

class Controller extends AbstractController {
    private final Service service;

    Controller(Service service) {
        this.service = service;
    }

    @Override
    public JPanel getLayout() {
        JPanel layout = new JPanel();
        layout.setLayout(new BoxLayout(layout, BoxLayout.Y_AXIS));
        layout.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JTextField idField = new JTextField(20);
        idField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        idField.setToolTipText("ID");

        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));

        JButton signUpButton = new JButton("Sign Up");
        JButton homeButton = new JButton("Home");

        signUpButton.addActionListener(e -> onSignUpButtonClick(idField.getText(), new String(passwordField.getPassword())));
        homeButton.addActionListener(e -> onHomeButtonClick());

        layout.add(new JLabel("ID:"));
        layout.add(idField);
        layout.add(Box.createVerticalStrut(10));
        layout.add(new JLabel("Password:"));
        layout.add(passwordField);
        layout.add(Box.createVerticalStrut(20));
        layout.add(signUpButton);
        layout.add(Box.createVerticalStrut(10));
        layout.add(homeButton);

        return layout;
    }

    private void onSignUpButtonClick(String id, String pw) {
        if (id.isEmpty() || pw.isEmpty()) {
            alert();
            return;
        }

        service.signUp(id, pw);
        System.out.printf("Expert User Sign up. ID: %s, pw: %s%n", id, pw);
        dispatcher.dispatch(new SignIn());
    }

    private void alert() {
        JOptionPane.showMessageDialog(
                null,
                "Please fill out all fields.",
                "Sign Up Error",
                JOptionPane.WARNING_MESSAGE
        );
    }

    private void onHomeButtonClick() {
        dispatcher.dispatch(new SignIn());
        System.out.println("Go Home");
    }
}