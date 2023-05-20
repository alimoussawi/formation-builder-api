package com.api.formationbuilder.model.grid

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size


data class GridDTO(
    @field:NotEmpty
    val name: String,
    @field:Size(message = "grid rows size should always be 6", min = 6, max = 6)
    val gridRows: List<GridRowDTO>
)
