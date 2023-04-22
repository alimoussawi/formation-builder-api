package com.api.formationbuilder.service

import com.api.formationbuilder.model.player.PlayerDTO
import org.springframework.stereotype.Service

@Service
open class PlayerService {
    fun getPlayer(): PlayerDTO {
        return PlayerDTO("ali", 12, listOf())
    }

}