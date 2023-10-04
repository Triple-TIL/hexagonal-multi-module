package com.example.user.application.port.out

import com.example.user.domain.User

interface SaveUserPort {

    fun save(user: User): User
}