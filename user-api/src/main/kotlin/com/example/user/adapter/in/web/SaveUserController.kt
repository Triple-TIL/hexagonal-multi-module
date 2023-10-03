package com.example.user.adapter.`in`.web

import com.example.user.adapter.`in`.web.request.SaveUserRequest
import com.example.user.adapter.`in`.web.response.SaveUserResponse
import com.example.user.application.port.`in`.FindUserUseCase
import com.example.user.application.port.`in`.SaveUserUseCase
import com.example.user.application.port.`in`.dto.SaveUserCommand
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class SaveUserController(
    private val saveUserUseCase: SaveUserUseCase,
    private val findUserUseCase: FindUserUseCase
) {

    @PostMapping("/users")
    fun saveUser(@RequestBody request: SaveUserRequest): SaveUserResponse {
        require(findUserUseCase.findByName(request.name) == null) { "등록된 이름이 있습니다." }

        val userCommand = SaveUserCommand(request.name, request.email, request.password)
        return saveUserUseCase.save(userCommand)
            .let { SaveUserResponse(it.id, it.name, it.email) }
    }

}