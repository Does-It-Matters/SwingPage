package org.example.page.task.signin;

import org.example.core.page.cookie.ICookie;
import org.example.core.page.presentation.AbstractIPage;

public class AssemblerSignIn {
    public static AbstractIPage getPage(ICookie cookie) {
        final var request = new Request();
        final var service = new Service(request, cookie);
        final var controller = new Controller(service);
        return new Page(controller);
    }
}
