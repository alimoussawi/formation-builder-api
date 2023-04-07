package com.api.formationbuilder.web.player

import com.api.formationbuilder.model.Player
import com.api.formationbuilder.service.PlayerService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class PlayerController(private val playerService: PlayerService) {

    @GetMapping("/players")
    fun getPlayer(): ResponseEntity<Player> {
        return ResponseEntity.ok(playerService.getPlayer())
    }
}