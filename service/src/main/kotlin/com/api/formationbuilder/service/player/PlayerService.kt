package com.api.formationbuilder.service.player

import com.api.formationbuilder.model.player.PlayerDTO
import com.api.formationbuilder.model.player.PlayerResponseDTO
import com.api.formationbuilder.persistence.player.PlayerRepository
import com.api.formationbuilder.service.mappers.toPlayer
import com.api.formationbuilder.service.mappers.toPlayerResponseDTO
import com.api.formationbuilder.service.user.UserService
import org.springframework.stereotype.Service

@Service
class PlayerService(
    private val playerRepository: PlayerRepository,
    private val userService: UserService
) {

    fun getPlayers(): List<PlayerResponseDTO> {
        val createdBy = userService.getUserId()

        return playerRepository
            .findAllByCreatedBy(createdBy)
            .map {
                it.toPlayerResponseDTO()
            }
            .toList()
    }

    fun savePlayer(playerDTO: PlayerDTO) {
        val createdBy = userService.getUserId()
        val player = playerDTO.toPlayer(createdBy)
        playerRepository.save(player)
    }

}