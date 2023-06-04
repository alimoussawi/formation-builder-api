package com.api.formationbuilder.model.grid

import com.api.formationbuilder.model.position.BenchPositionDTO
import jakarta.validation.Valid
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size


data class GridDTO(
    @field:NotEmpty
    val name: String,

    @field:Size(message = "grid rows size should always be 6", min = 6, max = 6)
    @field:Valid
    val gridRows: List<GridRowDTO>,

    @field:Size(message = "grid bench size should always be 7", min = 7, max = 7)
    @field:Valid
    val gridBench: List<BenchPositionDTO>
)
