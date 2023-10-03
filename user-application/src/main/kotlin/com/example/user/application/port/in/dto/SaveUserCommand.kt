package com.example.user.application.port.`in`.dto

data class SaveUserCommand(
    val name: String,
    val email: String,
    val password: String
)
