package com.api.formationbuilder.service.player

import com.api.formationbuilder.model.player.PlayerDTO
import com.api.formationbuilder.persistence.player.Player
import com.api.formationbuilder.service.position.toPlayerPosition
import com.api.formationbuilder.service.position.toPlayerPositionDTO

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

