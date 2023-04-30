package com.api.formationbuilder.model.player

data class PlayerDTO(
    val name: String,
    val age: Int,
    val familiarPositions: List<PlayerPositionDTO>
)
