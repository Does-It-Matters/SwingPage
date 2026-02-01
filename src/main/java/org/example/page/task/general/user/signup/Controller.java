package org.example.page.task.general.user.signup;

import org.example.core.page.presentation.AbstractController;
import org.example.event.SignInEvent;

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
        layout.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));

        JTextField idField = new JTextField(15);
        JPasswordField passwordField = new JPasswordField(15);
        JButton signUpButton = new JButton("Sign Up (General)");
        JButton homeButton = new JButton("Home");

        idField.setAlignmentX(Component.CENTER_ALIGNMENT);
        passwordField.setAlignmentX(Component.CENTER_ALIGNMENT);
        signUpButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        homeButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        Dimension fieldSize = new Dimension(200, 30);
        idField.setMaximumSize(fieldSize);
        passwordField.setMaximumSize(fieldSize);

        signUpButton.addActionListener(e -> onSignUpButtonClick(idField.getText(), new String(passwordField.getPassword())));
        homeButton.addActionListener(e -> onHomeButtonClick());

        layout.add(new JLabel("General User ID"));
        layout.add(Box.createVerticalStrut(5));
        layout.add(idField);
        layout.add(Box.createVerticalStrut(15));
        layout.add(new JLabel("Password"));
        layout.add(Box.createVerticalStrut(5));
        layout.add(passwordField);
        layout.add(Box.createVerticalStrut(25));
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
        System.out.printf("General User Sign up. ID: %s, pw: %s%n", id, pw);
        publisher.publish(new SignInEvent());
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
        publisher.publish(new SignInEvent());
        System.out.println("Go Home");
    }
}