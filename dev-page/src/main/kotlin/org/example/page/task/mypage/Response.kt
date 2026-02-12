package org.example.page.task.mypage

internal class Response {
    var result: String? = null
    var statusCode: Int = 0

    override fun toString(): String {
        return String.format("MyProfileResponse{result='%s', statusCode=%d}", result, statusCode)
    }
}
