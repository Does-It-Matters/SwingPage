package org.example.page.task.expert.user.signup

internal class Response {
    var result: String? = null
    var statusCode: Int = 0

    override fun toString(): String {
        return String.format("SignUpResponse{result='%s', statusCode=%d}", result, statusCode)
    }
}
