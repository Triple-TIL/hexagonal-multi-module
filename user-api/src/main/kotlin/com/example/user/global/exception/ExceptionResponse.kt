package com.example.user.global.exception

data class ExceptionResponse(
    val type: ResultType,
    val message: String?
) {

    companion object {
        fun error(message: String?): ExceptionResponse {
            return ExceptionResponse(ResultType.ERROR, message)
        }
    }

}
