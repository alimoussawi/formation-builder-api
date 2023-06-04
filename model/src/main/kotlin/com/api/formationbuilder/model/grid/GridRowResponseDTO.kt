package com.api.formationbuilder.model.grid

import com.api.formationbuilder.model.position.GridPositionResponseDTO

data class GridRowResponseDTO(
    val index: Int,
    val name: String,
    val rowPositions: List<GridPositionResponseDTO>
)
