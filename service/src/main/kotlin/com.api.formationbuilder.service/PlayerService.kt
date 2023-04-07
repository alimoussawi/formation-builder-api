package com.api.formationbuilder.service
import com.api.formationbuilder.model.Player
import org.springframework.stereotype.Service

@Service
open class PlayerService {
    fun getPlayer(): Player {
        return Player("ali", 123)
    }

}