package com.api.formationbuilder.model.player

import com.api.formationbuilder.model.constants.PositionName

data class PlayerPositionDTO(val name: PositionName, val roles: List<String>)
