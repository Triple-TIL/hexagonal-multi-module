package com.example.user.adapter.out.persistence

import com.example.user.application.port.out.FindUserPort
import com.example.user.application.port.out.SaveUserPort
import com.example.user.domain.entity.UserEntity
import com.example.user.domain.repository.UserRepository
import org.springframework.stereotype.Component

@Component
class UserPersistenceAdapter(
    private val userRepositoryImpl: UserRepositoryImpl,
    private val userRepository: UserRepository
) : FindUserPort, SaveUserPort {

    override fun findAll(): List<UserEntity> {
        return userRepositoryImpl.findAll()
    }

    override fun findByName(name: String): UserEntity? {
        return userRepositoryImpl.findByName(name)
    }

    override fun save(user: UserEntity): UserEntity {
        return userRepository.save(user)
    }

}