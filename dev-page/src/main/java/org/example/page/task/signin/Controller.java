package org.example.page.task.signin;

import org.example.core.page.application.AbstractService;
import org.example.core.page.presentation.AbstractController;
import org.example.intent.ExpertUserSignUp;
import org.example.intent.GeneralUserSignUp;
import org.example.intent.MyPage;

import javax.swing.*;
import java.awt.*;

class Controller extends AbstractController {

    Controller(AbstractService service) {
        super(service);
    }

    @Override
    public JPanel getLayout() {
        JPanel layout = new JPanel();
        layout.setLayout(new BoxLayout(layout, BoxLayout.Y_AXIS));
        layout.setBorder(BorderFactory.createEmptyBorder(40, 60, 40, 60));

        JTextField idField = new JTextField(20);
        JPasswordField passwordField = new JPasswordField(20);

        JButton loginButton = new JButton("Login");
        JButton generalUserSignUpButton = new JButton("Sign Up as General user");
        JButton expertUserSignUpButton = new JButton("Sign Up as Expert user");

        Component[] components = {idField, passwordField, loginButton, generalUserSignUpButton, expertUserSignUpButton};
        Dimension buttonSize = new Dimension(250, 35);

        for (Component comp : components) {
            ((JComponent) comp).setAlignmentX(Component.CENTER_ALIGNMENT);
            ((JComponent) comp).setMaximumSize(buttonSize);
        }

        loginButton.addActionListener(e -> onLoginButtonClick(idField.getText(), new String(passwordField.getPassword())));
        generalUserSignUpButton.addActionListener(e -> onGeneralUserSignUpButtonClick());
        expertUserSignUpButton.addActionListener(e -> onExpertUserSignUpButtonClick());

        layout.add(new JLabel("ID"));
        layout.add(idField);
        layout.add(Box.createVerticalStrut(10));

        layout.add(new JLabel("Password"));
        layout.add(passwordField);
        layout.add(Box.createVerticalStrut(20));

        layout.add(loginButton);
        layout.add(Box.createVerticalStrut(10));
        layout.add(generalUserSignUpButton);
        layout.add(Box.createVerticalStrut(10));
        layout.add(expertUserSignUpButton);

        return layout;
    }

    private void onLoginButtonClick(String id, String pw) {
        if (service instanceof Service user) {
            user.login(id, pw);
            System.out.printf("Sign in. ID: %s, pw: %s%n", id, pw);
            dispatcher.dispatch(new MyPage());
        }
    }

    private void onGeneralUserSignUpButtonClick() {
        System.out.println("general user Sign up");
        dispatcher.dispatch(new GeneralUserSignUp());
    }

    private void onExpertUserSignUpButtonClick() {
        System.out.println("expert user Sign up");
        dispatcher.dispatch(new ExpertUserSignUp());
    }
}