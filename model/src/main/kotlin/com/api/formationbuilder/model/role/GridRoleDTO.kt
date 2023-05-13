package com.api.formationbuilder.model.role

import com.api.formationbuilder.model.constants.Role

data class GridRoleDTO(
    val role: Role,
    val possibleDuties:List<String>
)
