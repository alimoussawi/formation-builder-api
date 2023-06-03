package com.api.formationbuilder.model.position

import com.api.formationbuilder.model.constants.Position

data class GridPositionDTO(
    val index: Int,
    val position: Position,
    val playerId: String?
)