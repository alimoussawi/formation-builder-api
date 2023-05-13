package com.api.formationbuilder.model.role

import com.api.formationbuilder.model.constants.Duty
import com.api.formationbuilder.model.constants.Role
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import org.hibernate.validator.constraints.UniqueElements

data class PlayerRoleDTO(
    @field:NotNull
    val role: Role,

    @field:NotEmpty(message = "role duties cannot be empty")
    @field:UniqueElements(message = "duties within a role cannot contain duplicates")
    val familiarDuties: List<Duty>

) {
    override fun equals(other: Any?): Boolean {
        return other is PlayerRoleDTO && other.role == role
    }

    override fun hashCode(): Int {
        var result = role.hashCode()
        result *= 31
        return result
    }
}

