package com.api.formationbuilder.web.player

import com.api.formationbuilder.model.player.PlayerDTO
import com.api.formationbuilder.model.player.PlayerResponseDTO
import com.api.formationbuilder.service.player.PlayerService
import com.api.formationbuilder.service.validation.ValidPlayer
import com.api.formationbuilder.web.swagger.SwaggerSecurity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/players")
@Validated
class PlayerController(private val playerService: PlayerService) {

    @GetMapping
    @SwaggerSecurity
    fun getPlayers(): ResponseEntity<List<PlayerResponseDTO>> {
        return ResponseEntity.ok(playerService.getPlayers())
    }

    @PostMapping
    @SwaggerSecurity
    fun savePlayer(@RequestBody @ValidPlayer player: PlayerDTO): ResponseEntity<Unit> {
        return ResponseEntity.status(HttpStatus.CREATED).body(playerService.savePlayer(player))
    }
}