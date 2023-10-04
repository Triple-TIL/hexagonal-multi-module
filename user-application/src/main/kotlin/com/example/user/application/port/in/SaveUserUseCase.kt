package com.example.user.application.port.`in`

import com.example.user.application.port.`in`.dto.SaveUserCommand
import com.example.user.domain.User

interface SaveUserUseCase {

    fun save(saveUserCommand: SaveUserCommand): User

}