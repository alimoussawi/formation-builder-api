package com.api.formationbuilder.model.position

import com.api.formationbuilder.model.player.PlayerResponseDTO

data class BenchPositionResponseDTO(
    val index: Int,
    val player: PlayerResponseDTO? = null
)