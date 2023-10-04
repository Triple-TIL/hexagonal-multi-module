package com.example.user.application.service

import com.example.user.application.port.`in`.FindUserUseCase
import com.example.user.application.port.out.FindUserPort
import com.example.user.domain.User
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class FindUserService(
    private val findUserPort: FindUserPort
): FindUserUseCase {

    override fun findAll(): List<User> {
        return findUserPort.findAll()
    }

    override fun findByName(name: String): User? {
        return findUserPort.findByName(name)
    }
}