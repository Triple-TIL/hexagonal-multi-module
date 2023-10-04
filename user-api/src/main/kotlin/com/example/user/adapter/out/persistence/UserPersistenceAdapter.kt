package com.example.user.adapter.out.persistence

import com.example.user.adapter.out.persistence.entity.UserEntity
import com.example.user.adapter.out.persistence.mapper.UserMapper
import com.example.user.adapter.out.persistence.repository.UserRepository
import com.example.user.adapter.out.persistence.repository.UserRepositoryImpl
import com.example.user.application.port.out.FindUserPort
import com.example.user.application.port.out.SaveUserPort
import com.example.user.domain.User
import org.springframework.stereotype.Component

@Component
class UserPersistenceAdapter(
    private val userRepositoryImpl: UserRepositoryImpl,
    private val userRepository: UserRepository,
    private val userMapper: UserMapper
) : FindUserPort, SaveUserPort {

    override fun findAll(): List<User> {
        return userRepositoryImpl.findAll()
            .map { userMapper.mapToUserInfoResponse(it) }
    }

    override fun findByName(name: String): User? {
        val user = userRepositoryImpl.findByName(name) ?: return null
        return userMapper.mapToUserInfoResponse(user)
    }

    override fun save(user: User): User {
        val userEntity = UserEntity(user.name, user.email, user.password)
        return userMapper.mapToUserInfoResponse(userRepository.save(userEntity))
    }

}