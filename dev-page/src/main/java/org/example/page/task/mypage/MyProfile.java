package org.example.page.task.mypage;

class MyProfile {
    private final String id;
    private final String role;

    MyProfile(String id, String role) {
        this.id = id;
        this.role = role;
    }

    String getId() {
        return id;
    }

    String getRole() {
        return role;
    }
}
