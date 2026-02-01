package org.example.page.task.general.user.signup;

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
        return String.format("SignUpResponse{result='%s', statusCode=%d}", result, statusCode);
    }
}
