package com.example.user.global.exception.custom

class NotFoundUserException(): RuntimeException(MESSAGE) {

    companion object {
        private const val MESSAGE = "유저를 찾지 못헀습니다."
    }

}