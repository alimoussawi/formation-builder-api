package com.api.formationbuilder.service.mappers

import com.api.formationbuilder.model.grid.GridRowDTO
import com.api.formationbuilder.model.grid.GridRowResponseDTO
import com.api.formationbuilder.persistence.grid.GridRow
import com.api.formationbuilder.persistence.player.PlayerRepository

fun GridRowDTO.toGridRow(playerRepository: PlayerRepository) = GridRow(
    index = index,
    name = name,
    rowPositions = rowPositions.map { it.toGridPosition(playerRepository) }
)

fun GridRow.toGridRowResponseDTO() = GridRowResponseDTO(
    index = index,
    name = name,
    rowPositions = rowPositions.map { it.toGridPositionResponseDTO() }
)

