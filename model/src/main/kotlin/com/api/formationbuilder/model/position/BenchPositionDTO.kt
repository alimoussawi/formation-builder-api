package com.api.formationbuilder.model.position

import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min

data class BenchPositionDTO(
    @Min(value = 0, message = "min bench position index is 0")
    @Max(value = 6, message = "max bench position index is 6")
    val index: Int,
    val playerId: String? = null
)
