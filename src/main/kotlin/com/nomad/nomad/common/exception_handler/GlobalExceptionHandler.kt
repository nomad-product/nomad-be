package com.nomad.nomad.common.exception_handler

import com.nomad.nomad.common.exception.NotFoundEntityException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundEntityException::class)
    fun handleNotFoundEntityException(e: NotFoundEntityException): ResponseEntity<Nothing> {
        return ResponseEntity.notFound().build()
    }
}
