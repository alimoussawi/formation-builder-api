package com.api.formationbuilder.persistence.grid

data class GridRow(
    val index: Int,
    val name: String,
    val rowPositions: List<GridPosition>
)
