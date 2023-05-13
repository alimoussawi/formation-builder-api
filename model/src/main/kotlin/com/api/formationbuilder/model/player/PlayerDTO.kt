package com.api.formationbuilder.model.player

import com.api.formationbuilder.model.position.PlayerPositionDTO
import jakarta.validation.Valid
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Positive
import jakarta.validation.constraints.Size
import org.hibernate.validator.constraints.UniqueElements

data class PlayerDTO(

    @field:NotBlank
    @field:Size(min = 3, max = 15, message = "invalid player name length")
    val name: String,

    @field:Positive
    @field:Min(15)
    val age: Int,

    @field:Size(min = 1, max = 11, message = "player can have between 1 -> 11 familiar positions")
    @field:UniqueElements(message = "player familiar positions cannot contain duplicates")
    @field:Valid
    val familiarPositions: List<PlayerPositionDTO>
)
