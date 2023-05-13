package com.api.formationbuilder.model.position

import com.api.formationbuilder.model.constants.Position
import com.api.formationbuilder.model.player.PlayerDTO

data class GridPositionDTO (
    val position: Position,
    val currentPlayerRef: PlayerDTO?
)