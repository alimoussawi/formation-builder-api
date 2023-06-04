package com.api.formationbuilder.service.mappers

import com.api.formationbuilder.model.constants.Duty
import com.api.formationbuilder.model.constants.Position
import com.api.formationbuilder.model.constants.Role
import com.api.formationbuilder.model.position.*
import com.api.formationbuilder.model.role.PlayerRoleDTO
import com.api.formationbuilder.persistence.grid.BenchPosition
import com.api.formationbuilder.persistence.grid.GridPosition
import com.api.formationbuilder.persistence.player.PlayerPosition
import com.api.formationbuilder.persistence.player.PlayerRepository
import com.api.formationbuilder.persistence.player.PlayerRole
import com.api.formationbuilder.service.exception.PlayerNotFoundException

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

fun GridPositionDTO.toGridPosition(playerRepository: PlayerRepository) = GridPosition(
    index = index,
    name = position.name,
    player = playerId?.let { playerRepository.findById(it).orElseThrow { PlayerNotFoundException("player with id : $it not found") } }
)

fun GridPosition.toGridPositionResponseDTO() = GridPositionResponseDTO(
    index = index,
    position = Position.valueOf(name),
    player = player?.toPlayerResponseDTO()
)

fun BenchPosition.toBenchPositionDTO() = BenchPositionResponseDTO(
    index = index,
    player = player?.toPlayerResponseDTO()
)

fun BenchPositionDTO.toBenchPosition(playerRepository: PlayerRepository) = BenchPosition(
    index = index,
    player = playerId?.let { playerRepository.findById(it).orElseThrow { PlayerNotFoundException("player with id : $it not found") } }
)