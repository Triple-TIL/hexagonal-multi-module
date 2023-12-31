package com.example.user.adapter.out.persistence.repository

import com.example.user.adapter.out.persistence.entity.UserEntity
import com.example.user.global.config.singleOrNullQuery
import com.linecorp.kotlinjdsl.querydsl.expression.column
import com.linecorp.kotlinjdsl.spring.data.SpringDataQueryFactory
import com.linecorp.kotlinjdsl.spring.data.listQuery
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl(
    private val queryFactory: SpringDataQueryFactory
) {

    fun findAll(): List<UserEntity> {
        return queryFactory.listQuery<UserEntity> {
            select(entity(UserEntity::class))
            from(entity(UserEntity::class))
        }
    }

    fun findByName(name: String): UserEntity? {
        return queryFactory.singleOrNullQuery<UserEntity> {
            select(entity(UserEntity::class))
            from(entity(UserEntity::class))
            where(column(UserEntity::name).equal(name))
        }
    }

}