package com.example.user.application.service

import com.example.user.application.port.`in`.FindUserUseCase
import com.example.user.application.port.out.FindUserPort
import com.example.user.domain.mapper.UserMapper
import com.example.user.domain.vo.User
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class FindUserService(
    private val findUserPort: FindUserPort
): FindUserUseCase {

    override fun findAll(): List<User> {
        return findUserPort.findAll()
            .map { user -> UserMapper.mapToUserInfoResponse(user) }
            .toList()
    }

    override fun findByName(name: String): User? {
        val user = findUserPort.findByName(name) ?: return null
        return UserMapper.mapToUserInfoResponse(user)
    }
}