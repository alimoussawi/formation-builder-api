package com.api.formationbuilder.service
import com.api.formationbuilder.model.player.PlayerDTO
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
open class PlayerService {
    fun getPlayer(): PlayerDTO {
        throw RuntimeException("not implemented")
    }

}