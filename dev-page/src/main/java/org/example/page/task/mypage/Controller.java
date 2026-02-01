package org.example.page.task.mypage;

import org.example.core.page.application.AbstractService;
import org.example.core.page.presentation.AbstractController;
import org.example.intent.SignIn;

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
        layout.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));

        String idText = "ID: ";
        String roleText = "ROLE: ";

        if (service instanceof Service user) {
            MyProfile myProfile = user.getMyProfile();
            idText += myProfile.getId();
            roleText += myProfile.getRole();
        }

        JLabel idLabel = new JLabel(idText);
        JLabel roleLabel = new JLabel(roleText);
        JButton logoutButton = new JButton("Log Out");

        idLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        roleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        logoutButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        idLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        roleLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));

        logoutButton.addActionListener(e -> onLogoutButtonClick());

        layout.add(idLabel);
        layout.add(Box.createVerticalStrut(10));
        layout.add(roleLabel);
        layout.add(Box.createVerticalStrut(30)); // 로그아웃 버튼 전 더 넓은 간격
        layout.add(logoutButton);

        return layout;
    }

    /**
     * <b> 역할: 로그아웃 </b>
     */
    private void onLogoutButtonClick() {
        System.out.println("logout");
        dispatcher.dispatch(new SignIn());
    }
}