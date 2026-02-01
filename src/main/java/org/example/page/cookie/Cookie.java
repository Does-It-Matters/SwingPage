package org.example.page.cookie;

import org.example.core.page.cookie.ICookie;
import org.example.page.cookie.store.Role;

public class Cookie implements ICookie, Role {
    private String id;
    private String role;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getRole() {
        return role;
    }

    @Override
    public void setRole(String role) {
        this.role = role;
    }
}
