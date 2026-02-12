package org.example.page.task.signin

internal class Response {
    var result: String? = null
    var statusCode: Int = 0

    override fun toString(): String {
        return String.format("SignInResponse{result='%s', statusCode=%d}", result, statusCode)
    }
}
