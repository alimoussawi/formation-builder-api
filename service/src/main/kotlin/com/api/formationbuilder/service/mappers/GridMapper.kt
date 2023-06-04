package com.api.formationbuilder.service.mappers

import com.api.formationbuilder.model.grid.GridDTO
import com.api.formationbuilder.model.grid.GridResponseDTO
import com.api.formationbuilder.persistence.grid.Grid
import com.api.formationbuilder.persistence.player.PlayerRepository


fun GridDTO.toGrid(createdBy: String, playerRepository: PlayerRepository) = Grid(
    name = name,
    createdBy = createdBy,
    gridRows = gridRows.map { it.toGridRow(playerRepository) },
    gridBench = gridBench.map { it.toBenchPosition(playerRepository) }
)

fun Grid.toGridResponseDTO() = GridResponseDTO(
    id = id.toString(),
    name = name,
    gridRows = gridRows.map { it.toGridRowResponseDTO() },
    gridBench = gridBench.map { it.toBenchPositionDTO() }
)