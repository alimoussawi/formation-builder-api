package com.api.formationbuilder.service.mappers

import com.api.formationbuilder.model.player.PlayerDTO
import com.api.formationbuilder.model.player.PlayerResponseDTO
import com.api.formationbuilder.persistence.player.Player

fun PlayerDTO.toPlayer(createdBy: String) = Player(
    name = name,
    age = age,
    familiarPositions = familiarPositions.map { it.toPlayerPosition() },
    createdBy = createdBy
)


fun Player.toPlayerDTO() = PlayerDTO(
    name = name,
    age = age,
    familiarPositions = familiarPositions.map { it.toPlayerPositionDTO() }
)

fun Player.toPlayerResponseDTO() = PlayerResponseDTO(
    id = id.toString(),
    name = name,
    age = age,
    familiarPositions = familiarPositions.map { it.toPlayerPositionDTO() }
)

