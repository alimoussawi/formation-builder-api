package com.api.formationbuilder.web.exceptionHandler

import com.api.formationbuilder.model.constants.Position
import com.fasterxml.jackson.databind.exc.InvalidFormatException
import jakarta.validation.ConstraintViolationException
import org.springframework.http.HttpStatus
import org.springframework.http.ProblemDetail
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class RestExceptionHandler {

    @ExceptionHandler(HttpMessageNotReadableException::class)
    fun handleHttpMessageNotReadableException(
        ex: HttpMessageNotReadableException
    ): ResponseEntity<ProblemDetail> {
        val cause = ex.cause as? InvalidFormatException
        if (cause != null && cause.targetType == Position::class.java) {
            val message =
                "Invalid value for position: ${cause.value}. Must be one of ${Position.values().joinToString(", ")}"
            val problemDetail: ProblemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, message)
            problemDetail.setProperty("field", "player.position")
            return ResponseEntity.badRequest().body(problemDetail)
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(
                ProblemDetail.forStatusAndDetail(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "An error occurred while processing your request."
                )
            )
    }

    /**
     *     for the custom validators , ex : PlayerValidator
     */
    @ExceptionHandler(ConstraintViolationException::class)
    fun handleConstraintViolationException(
        ex: ConstraintViolationException
    ): ResponseEntity<ProblemDetail> {
        return ResponseEntity.badRequest()
            .body(
                ProblemDetail.forStatusAndDetail(
                    HttpStatus.BAD_REQUEST,
                    ex.constraintViolations.joinToString { constraintViolation -> constraintViolation.messageTemplate }
                )
            )
    }


    /**
     *     for the annotation validations , ex : @NotEmpty, @Min ....
     */
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValidException(
        ex: MethodArgumentNotValidException
    ): ResponseEntity<ProblemDetail> {
        return ResponseEntity.badRequest()
            .body(
                ProblemDetail.forStatusAndDetail(
                    HttpStatus.BAD_REQUEST,
                    ex.fieldError?.defaultMessage.toString()
                )
            )
    }

}
