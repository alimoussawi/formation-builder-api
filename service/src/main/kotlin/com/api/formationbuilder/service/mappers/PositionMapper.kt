package com.api.formationbuilder.service.mappers

import com.api.formationbuilder.model.constants.Duty
import com.api.formationbuilder.model.constants.Position
import com.api.formationbuilder.model.constants.Role
import com.api.formationbuilder.model.position.GridPositionDTO
import com.api.formationbuilder.model.position.PlayerPositionDTO
import com.api.formationbuilder.model.role.PlayerRoleDTO
import com.api.formationbuilder.persistence.grid.GridPosition
import com.api.formationbuilder.persistence.player.PlayerPosition
import com.api.formationbuilder.persistence.player.PlayerRole

fun PlayerPositionDTO.toPlayerPosition() =
    PlayerPosition(
        name = position.name,
        familiarRoles = familiarRoles.map { roleDTO ->
            PlayerRole(
                roleDTO.role.name,
                roleDTO.familiarDuties.map { duty -> duty.name })
        })

fun PlayerPosition.toPlayerPositionDTO() =
    PlayerPositionDTO(
        position = Position.valueOf(name),
        familiarRoles = familiarRoles.map { playerRole ->
            PlayerRoleDTO(
                Role.valueOf(playerRole.name),
                familiarDuties = playerRole.duties.map { Duty.valueOf(it) })
        })

fun GridPositionDTO.toGridPosition() = GridPosition(
    name = position.name,
    playerId = playerId
)

fun GridPosition.toGridPositionDTO() = GridPositionDTO(
    position = Position.valueOf(name),
    playerId = playerId
)