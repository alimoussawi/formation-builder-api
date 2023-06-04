package com.api.formationbuilder.model.position

import com.api.formationbuilder.model.constants.Position
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min

data class GridPositionDTO(
    @field:Min(value = 0, message = "min position index is 0")
    @field:Max(value = 4, message = "max position index is 4")
    val index: Int,

    val position: Position,
    val playerId: String? = null
)