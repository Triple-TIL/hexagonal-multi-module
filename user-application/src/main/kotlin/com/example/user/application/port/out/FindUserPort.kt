package com.example.user.application.port.out

import com.example.user.domain.entity.UserEntity

interface FindUserPort {

    fun findAll(): List<UserEntity>

    fun findByName(name: String): UserEntity?
}