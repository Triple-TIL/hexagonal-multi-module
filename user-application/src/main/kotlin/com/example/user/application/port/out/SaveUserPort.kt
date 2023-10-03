package com.example.user.application.port.out

import com.example.user.domain.entity.UserEntity

interface SaveUserPort {

    fun save(user: UserEntity): UserEntity
}