package com.api.formationbuilder.model.constants

enum class Duty {
    DEFEND,
    SUPPORT,
    ATTACK,
    AUTOMATIC;

    companion object {
        fun All(): List<Duty> {
            return Duty.values().toList()
        }
    }
}