package de.laclare.webshop.exceptions

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.net.ResponseCache
import java.net.http.HttpRequest
import javax.servlet.http.HttpServletRequest

@ControllerAdvice
class APIExceptionClass {

    @ExceptionHandler (WebshopException::class)
    fun handleErrors(request: HttpServletRequest, exception: WebshopException): ResponseEntity<ErrorInfo?> {

        println(exception.message)
        println(exception)

        val errorInfo: ErrorInfo = ErrorInfo(exception.message, request.contextPath)
        return ResponseEntity (errorInfo, exception.statusCode)
    }
    @ExceptionHandler (Throwable::class)
    fun handleErrors(request: HttpServletRequest, exception: Exception): ResponseEntity<ErrorInfo?> {
        val errorInfo: ErrorInfo = ErrorInfo(exception.message ?: "An exception occured", request.contextPath)
        return ResponseEntity (errorInfo, HttpStatus.INTERNAL_SERVER_ERROR)
    }
}

data class ErrorInfo(
    val error: String,
    val path: String
)