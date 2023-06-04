package com.api.formationbuilder.service.validation

import jakarta.validation.Constraint
import jakarta.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD, AnnotationTarget.VALUE_PARAMETER)
@MustBeDocumented
@Constraint(validatedBy = [GridValidator::class])
annotation class ValidGrid(
    val message: String = "Grid has invalid fields",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)