package com.api.formationbuilder.service.mappers

import com.api.formationbuilder.model.grid.GridRowDTO
import com.api.formationbuilder.persistence.grid.GridRow

fun GridRowDTO.toGridRow() = GridRow(
    index = index,
    name = name,
    rowPositions = rowPositions.map { it.toGridPosition() }
)

fun GridRow.toGridRowDTO() = GridRowDTO(
    index = index,
    name = name,
    rowPositions = rowPositions.map { it.toGridPositionDTO() }
)

