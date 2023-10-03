package com.example.user.global.exception

import com.example.user.global.exception.custom.NotFoundUserException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundUserException::class)
    fun handlerNotFoundException(e: NotFoundUserException): ResponseEntity<ExceptionResponse> {
        return ResponseEntity(ExceptionResponse.error(e.message), HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(IllegalArgumentException::class)
    fun handlerIllegalArgumentException(e: IllegalArgumentException): ResponseEntity<ExceptionResponse> {
        return ResponseEntity(ExceptionResponse.error(e.message), HttpStatus.NOT_FOUND)
    }

}