package com.api.formationbuilder.model.grid

import com.api.formationbuilder.model.position.BenchPositionResponseDTO

data class GridResponseDTO(
    val id: String,
    val name: String,
    val gridRows: List<GridRowResponseDTO>,
    val gridBench: List<BenchPositionResponseDTO>
)
