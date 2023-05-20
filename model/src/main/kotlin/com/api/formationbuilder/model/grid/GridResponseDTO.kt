package com.api.formationbuilder.model.grid

data class GridResponseDTO(
    val id: String,
    val name: String,
    val gridRows: List<GridRowDTO>
)
