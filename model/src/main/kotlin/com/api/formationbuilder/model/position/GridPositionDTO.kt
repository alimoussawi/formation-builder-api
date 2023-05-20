package com.api.formationbuilder.model.position

import com.api.formationbuilder.model.constants.Position

data class GridPositionDTO(
    val position: Position,
    val playerId: String?
)