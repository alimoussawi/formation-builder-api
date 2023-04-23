package com.api.formationbuilder.service

import com.api.formationbuilder.model.player.PlayerDTO
import com.api.formationbuilder.persistence.player.Player
import com.api.formationbuilder.persistence.player.PlayerRepository;
import org.springframework.stereotype.Service

@Service
open class PlayerService(private val playerRepository: PlayerRepository) {
    fun getPlayer(): PlayerDTO {
        return playerRepository
            .findAll()
            .map { player -> PlayerDTO(player.name, player.age, listOf()) }
            .first();
    }


    fun savePlayer() {
        val player: Player = Player(name = "ali1", age = 123);
        playerRepository.save(player)
    }
}