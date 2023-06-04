package com.api.formationbuilder.model.grid

import com.api.formationbuilder.model.position.GridPositionDTO
import jakarta.validation.Valid
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotEmpty

data class GridRowDTO(
    @Min(value = 0, message = "min row index is 0")
    @Max(value = 5, message = "max row index is 5")
    val index: Int,

    @field:NotEmpty
    val name: String,

    @field:NotEmpty(message = "rowPositions cannot be empty")
    @field:Valid
    val rowPositions: List<GridPositionDTO>
)