package com.api.formationbuilder.service.mappers

import com.api.formationbuilder.model.grid.GridDTO
import com.api.formationbuilder.model.grid.GridResponseDTO
import com.api.formationbuilder.persistence.grid.Grid


fun GridDTO.toGrid(createdBy: String) = Grid(
    name = name,
    createdBy = createdBy,
    gridRows = gridRows.map { it.toGridRow() }
)

fun Grid.toGridResponseDTO() = GridResponseDTO(
    id = id.toString(),
    name = name,
    gridRows = gridRows.map { it.toGridRowDTO() }
)