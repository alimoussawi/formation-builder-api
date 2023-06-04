package com.api.formationbuilder.persistence.grid

import com.api.formationbuilder.persistence.player.Player

data class BenchPosition(
    val index: Int,
    val player: Player?
)
