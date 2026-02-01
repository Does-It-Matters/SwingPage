package org.example.page.task.mypage;

import org.example.core.page.application.AbstractService;
import org.example.core.page.cookie.ICookie;
import org.example.page.cookie.store.Role;

class Service extends AbstractService {
    private final Request request;

    Service(Request request, ICookie cookie) {
        super(cookie);
        this.request = request;
    }

    MyProfile getMyProfile() {
        if (cookie instanceof Role role) {
            request.getMyProfile(role.getId());
            return new MyProfile(role.getId(), role.getRole());
        }
        return new MyProfile("default", "default");
    }
}
