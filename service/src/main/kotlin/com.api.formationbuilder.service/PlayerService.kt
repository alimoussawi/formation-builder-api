package com.api.formationbuilder.service

import com.api.formationbuilder.model.player.PlayerDTO
import com.api.formationbuilder.persistence.player.Player
import com.api.formationbuilder.persistence.player.PlayerRepository
import org.springframework.stereotype.Service

@Service
open class PlayerService(private val playerRepository: PlayerRepository, private val userService: UserService) {

    fun getPlayers(): List<PlayerDTO> {
        val createdBy = userService.getUserId()

        return playerRepository
            .findAllByCreatedBy(createdBy)
            .map { player -> PlayerDTO(player.name, player.age, listOf()) }
            .toList()
    }


    fun savePlayer(playerDTO: PlayerDTO) {
        val createdBy = userService.getUserId()

        val player = Player(name = playerDTO.name, age = playerDTO.age, createdBy = createdBy)
        playerRepository.save(player)
    }
}