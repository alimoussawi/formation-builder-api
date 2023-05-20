package com.api.formationbuilder.persistence.grid

import org.springframework.data.mongodb.repository.MongoRepository

interface GridRepository : MongoRepository<Grid, String> {
    fun findAllByCreatedBy(createdBy: String): List<Grid>
    fun save(grid: Grid): Grid
}