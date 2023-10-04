package com.example.user.adapter.out.persistence.mapper

import com.example.user.adapter.out.persistence.entity.UserEntity
import com.example.user.domain.User
import org.springframework.stereotype.Component

@Component
class UserMapper {

    fun mapToUserInfoResponse(user: UserEntity): User {
        return User(
            user.id ?: throw IllegalArgumentException(),
            user.name,
            user.email,
            user.password
        )
    }


}