package com.api.formationbuilder.persistence.player

import com.api.formationbuilder.persistence.position.PlayerPosition
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "players")
data class Player(
    @Id val id: ObjectId = ObjectId(),
    val name: String,
    val age: Int,
    val createdBy: String,
    val familiarPositions: List<PlayerPosition>
)