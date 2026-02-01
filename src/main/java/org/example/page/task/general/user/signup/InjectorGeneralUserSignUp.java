package org.example.page.task.general.user.signup;

import org.example.core.page.presentation.AbstractIPage;

public class InjectorGeneralUserSignUp {
    private static volatile AbstractIPage page;

    public static AbstractIPage getPage() {
        if (page == null) {
            synchronized (Page.class) {
                if (page == null) {
                    final var request = new Request();
                    final var service = new Service(request);
                    final var controller = new Controller(service);
                    page = new Page(controller);
                }
            }
        }
        return page;
    }
}
