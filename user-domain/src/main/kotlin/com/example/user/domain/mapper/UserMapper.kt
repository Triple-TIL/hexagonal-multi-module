package com.example.user.domain.mapper

import com.example.user.domain.entity.UserEntity
import com.example.user.domain.vo.User

class UserMapper {

    companion object {
        fun mapToUserInfoResponse(user: UserEntity): User {
            return User(
                user.id ?: throw IllegalArgumentException(),
                user.name,
                user.email,
                user.password
            )
        }
    }

}