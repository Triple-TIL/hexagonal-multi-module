package com.example.user.application.port.`in`

import com.example.user.domain.vo.User

interface FindUserUseCase {

    fun findAll(): List<User>

    fun findByName(name: String): User?
}