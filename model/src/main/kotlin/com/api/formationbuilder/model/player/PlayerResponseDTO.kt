package com.api.formationbuilder.model.player

import com.api.formationbuilder.model.position.PlayerPositionDTO

data class PlayerResponseDTO(
    val id: String,
    val name: String,
    val age: Int,
    val familiarPositions: List<PlayerPositionDTO>
)