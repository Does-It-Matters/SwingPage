package org.example.page.task.general.user.signup;

class Service {
    private final Request request;

    Service(Request request) {
        this.request = request;
    }

    void signUp(String id, String password) {
        request.signUp(new EntityGeneralUser(id, password));
    }
}
