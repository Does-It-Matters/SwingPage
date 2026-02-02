package org.example.page.task.general.user.signup;

import org.example.core.page.presentation.AbstractIPage;

public class AssemblerGeneralUserSignUp {
    public static AbstractIPage getPage() {
        final var request = new Request();
        final var service = new Service(request);
        final var controller = new Controller(service);
        return new Page(controller);
    }
}
