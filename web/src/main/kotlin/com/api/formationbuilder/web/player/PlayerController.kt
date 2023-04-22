package com.api.formationbuilder.web.player

import com.api.formationbuilder.model.player.PlayerDTO
import com.api.formationbuilder.service.PlayerService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class PlayerController(private val playerService: PlayerService) {

    @GetMapping("/players")
    @Operation(security = [SecurityRequirement(name = "bearerAuth")])
    fun getPlayer(): ResponseEntity<PlayerDTO> {
        return ResponseEntity.ok(playerService.getPlayer())
    }
}