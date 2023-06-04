package com.api.formationbuilder.model.position

import com.api.formationbuilder.model.constants.Position
import com.api.formationbuilder.model.player.PlayerResponseDTO

data class GridPositionResponseDTO(
    val index: Int,
    val position: Position,
    val player: PlayerResponseDTO? = null
)
