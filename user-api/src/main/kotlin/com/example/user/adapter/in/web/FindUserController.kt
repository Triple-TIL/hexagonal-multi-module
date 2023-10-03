package com.example.user.adapter.`in`.web

import com.example.user.adapter.`in`.web.response.UserInfoResponse
import com.example.user.application.port.`in`.FindUserUseCase
import com.example.user.global.exception.custom.NotFoundUserException
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class FindUserController(
    private val findUserUseCase: FindUserUseCase
) {

    @GetMapping("/users")
    fun findAll() : List<UserInfoResponse> {
        return findUserUseCase.findAll()
            .map { UserInfoResponse(it.id, it.name, it.email) }
            .toList()
    }

    @GetMapping("/users/{name}")
    fun findByName(@PathVariable name: String) : UserInfoResponse {
        val user = findUserUseCase.findByName(name) ?: throw NotFoundUserException()

        return user.let { UserInfoResponse(it.id, it.name, it.email) }
    }

}