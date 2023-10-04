package com.example.user.application.port.out

import com.example.user.domain.User

interface FindUserPort {

    fun findAll(): List<User>

    fun findByName(name: String): User?
}