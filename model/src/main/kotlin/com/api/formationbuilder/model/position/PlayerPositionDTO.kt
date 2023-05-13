package com.api.formationbuilder.model.position

import com.api.formationbuilder.model.constants.Position
import com.api.formationbuilder.model.role.PlayerRoleDTO
import jakarta.validation.Valid
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import org.hibernate.validator.constraints.UniqueElements

data class PlayerPositionDTO(
    @field:NotNull
    val position: Position,

    @field:NotEmpty(message = "position roles cannot be empty")
    @field:UniqueElements(message = "roles within a position cannot contain duplicates")
    @field:Valid
    val familiarRoles: List<PlayerRoleDTO>

) {
    override fun equals(other: Any?): Boolean {
        return other is PlayerPositionDTO && other.position == position
    }

    override fun hashCode(): Int {
        var result = position.hashCode()
        result *= 31
        return result
    }
}
