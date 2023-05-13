package com.api.formationbuilder.service.validation

import jakarta.validation.Constraint
import jakarta.validation.Payload
import kotlin.reflect.KClass


@Target(AnnotationTarget.FIELD, AnnotationTarget.VALUE_PARAMETER)
@MustBeDocumented
@Constraint(validatedBy = [PlayerValidator::class])
annotation class ValidPlayer(
    val message: String = "Player has invalid fields",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)