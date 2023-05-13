package com.api.formationbuilder.persistence.player

import org.springframework.data.mongodb.repository.MongoRepository

interface PlayerRepository : MongoRepository<Player, String>{
    fun findAllByCreatedBy(createdBy:String):List<Player>

    fun save(player: Player)
}