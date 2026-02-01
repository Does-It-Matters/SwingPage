package org.example.core.page.application;

import org.example.core.page.cookie.ICookie;

public abstract class AbstractService {
    protected ICookie cookie;

    public AbstractService(ICookie cookie) {
        this.cookie = cookie;
    }

    public AbstractService() {
        this.cookie = null;
    }
}
