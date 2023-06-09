package com.api.formationbuilder.persistence.grid

import com.api.formationbuilder.persistence.player.Player

data class GridPosition(
    val index: Int,
    val name: String,
    val player: Player?
)