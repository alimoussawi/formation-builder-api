package com.api.formationbuilder.persistence.position

import com.api.formationbuilder.persistence.role.PlayerRole

data class PlayerPosition(
    val name: String,
    val familiarRoles: List<PlayerRole>
)
