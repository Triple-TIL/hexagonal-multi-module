package com.example.user.application.service

import com.example.user.application.port.`in`.SaveUserUseCase
import com.example.user.application.port.`in`.dto.SaveUserCommand
import com.example.user.application.port.out.SaveUserPort
import com.example.user.domain.vo.User
import com.example.user.domain.entity.UserEntity
import com.example.user.domain.mapper.UserMapper
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class SaveUserService(
    private val saveUserPort: SaveUserPort
): SaveUserUseCase {

    override fun save(saveUserCommand: SaveUserCommand): User {
        val user = UserEntity(saveUserCommand.name, saveUserCommand.email, saveUserCommand.password)
        return saveUserPort.save(user)
            .let { UserMapper.mapToUserInfoResponse(it) }
    }

}