package org.example.page.task.signin;

import org.example.core.page.application.AbstractService;
import org.example.core.page.cookie.ICookie;
import org.example.page.cookie.store.Role;

class Service extends AbstractService {
    private final Request request;

    Service(Request request, ICookie cookie) {
        super(cookie);
        this.request = request;
    }

    void login(String id, String password) {
        request.login(new EntityUser(id, password));
        if (cookie instanceof Role role) {
            role.setId(id);
            role.setRole("temporary");
        }
    }
}
