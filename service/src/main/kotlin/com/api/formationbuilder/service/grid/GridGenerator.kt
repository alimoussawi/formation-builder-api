package com.api.formationbuilder.service.grid

import com.api.formationbuilder.model.constants.Row
import com.api.formationbuilder.model.grid.GridDTO
import com.api.formationbuilder.model.grid.GridRowDTO
import com.api.formationbuilder.model.position.BenchPositionDTO
import com.api.formationbuilder.model.position.GridPositionDTO
import org.springframework.stereotype.Service

@Service
class GridGenerator {

    fun generateEmptyGrid(): GridDTO {
        return GridDTO(DEFAULT_GRID_NAME, EMPTY_GRID_ROWS, EMPTY_GRID_BENCH)
    }

    companion object {
        private const val BENCH_SIZE = 7
        const val DEFAULT_GRID_NAME = "untitled-grid"
        val EMPTY_GRID_ROWS = Row.values().map { row ->
            GridRowDTO(
                index = row.ordinal,
                name = row.name,
                rowPositions = row.positions.mapIndexed { index, position -> GridPositionDTO(index, position) }
            )
        }

        val EMPTY_GRID_BENCH = (1..BENCH_SIZE).map { index -> BenchPositionDTO(index) }
    }
}