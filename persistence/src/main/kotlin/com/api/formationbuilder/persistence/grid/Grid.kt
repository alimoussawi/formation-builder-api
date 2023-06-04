package com.api.formationbuilder.persistence.grid

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "grids")
data class Grid(
    @Id val id: ObjectId = ObjectId(),
    val name: String,
    val createdBy: String,
    val gridRows: List<GridRow>,
    val gridBench: List<BenchPosition>
)
