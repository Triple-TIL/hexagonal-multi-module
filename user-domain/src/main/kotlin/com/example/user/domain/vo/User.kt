package com.example.user.domain.vo

data class User (
    val id: Long,
    var name: String,
    var email: String,
    val password: String
)