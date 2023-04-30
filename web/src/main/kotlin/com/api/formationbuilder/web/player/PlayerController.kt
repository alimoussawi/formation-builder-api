package com.api.formationbuilder.web.player

import com.api.formationbuilder.model.player.PlayerDTO
import com.api.formationbuilder.service.PlayerService
import com.api.formationbuilder.service.UserService
import com.api.formationbuilder.web.swagger.SwaggerSecurity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class PlayerController(private val playerService: PlayerService, private val userService: UserService) {

    @GetMapping("/players")
    @SwaggerSecurity
    fun getPlayer(): ResponseEntity<List<PlayerDTO>> {
        return ResponseEntity.ok(playerService.getPlayers())
    }

    @PostMapping("/players")
    @SwaggerSecurity
    fun savePlayer(@RequestBody player: PlayerDTO): ResponseEntity<Unit> {
        playerService.savePlayer(player)
        return ResponseEntity.status(HttpStatus.CREATED).build()
    }
}