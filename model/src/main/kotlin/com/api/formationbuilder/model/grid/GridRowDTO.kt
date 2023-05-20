package com.api.formationbuilder.model.grid

import com.api.formationbuilder.model.position.GridPositionDTO

data class GridRowDTO(
    val index: Int,
    val name: String,
    val rowPositions: List<GridPositionDTO>
)