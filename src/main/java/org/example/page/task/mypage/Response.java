package org.example.page.task.mypage;

class Response {
    private String result;
    private int statusCode;

    String getResult() {
        return result;
    }

    void setResult(String result) {
        this.result = result;
    }

    int getStatusCode() {
        return statusCode;
    }

    void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public String toString() {
        return String.format("MyProfileResponse{result='%s', statusCode=%d}", result, statusCode);
    }
}
