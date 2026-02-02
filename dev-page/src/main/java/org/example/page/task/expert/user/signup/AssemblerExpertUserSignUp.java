package org.example.page.task.expert.user.signup;

import org.example.core.page.presentation.AbstractIPage;

public class AssemblerExpertUserSignUp {
    public static AbstractIPage getPage() {
        final var request = new Request();
        final var service = new Service(request);
        final var controller = new Controller(service);
        return new Page(controller);
    }
}
