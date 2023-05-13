package com.api.formationbuilder.model.constants

import com.api.formationbuilder.model.constants.Duty.*

enum class Role(val possibleDuties: List<Duty>) {

    GOAL_KEEPER(listOf(DEFEND)),
    SWEEPER_KEEPER(listOf(DEFEND, SUPPORT)),

    FULL_BACK(Duty.All()),
    CENTRAL_DEFENDER(listOf(DEFEND)),
    BALL_PLAYING_DEFENDER(listOf(DEFEND, SUPPORT)),
    NO_NONSENSE_DEFENDER(listOf(DEFEND)),

    WING_BACK(Duty.All()),
    COMPLETE_WING_BACK(Duty.All()),
    DEFENSIVE_MIDFIELDER(listOf(DEFEND, SUPPORT)),
    HALF_BACK(listOf(DEFEND)),
    BALL_WINNING_MIDFIELDER(listOf(DEFEND, SUPPORT)),

    DEEP_LYING_PLAYMAKER(listOf(DEFEND, SUPPORT)),
    CENTRAL_MIDFIELDER(Duty.All()),
    ADVANCED_PLAYMAKER(listOf(SUPPORT, ATTACK)),
    BOX_TO_BOX_MIDFIELDER(listOf(SUPPORT)),
    ROAMING_PLAYMAKER(listOf(SUPPORT)),
    MEZZALA(listOf(SUPPORT, ATTACK)),

    WIDE_MIDFIELDER(Duty.All()),
    WINGER(listOf(SUPPORT, ATTACK)),
    DEFENSIVE_WINGER(listOf(DEFEND, SUPPORT)),
    INVERTED_WINGER(listOf(SUPPORT, ATTACK)),

    INSIDE_FORWARD(listOf(SUPPORT, ATTACK)),
    TREQUARTISTA(listOf(ATTACK)),
    RAUMDEUTER(listOf(ATTACK)),

    ATTACKING_MIDFIELDER(listOf(SUPPORT, ATTACK)),
    ENGANCHE(listOf(SUPPORT)),
    SHADOW_STRIKER(listOf(ATTACK)),

    DEEP_LYING_FORWARD(listOf(SUPPORT, ATTACK)),
    ADVANCED_FORWARD(listOf(ATTACK)),
    TARGET_MAN(listOf(SUPPORT, ATTACK)),
    POACHER(listOf(ATTACK)),
    COMPLETE_FORWARD(listOf(SUPPORT, ATTACK)),
    PRESSING_FORWARD(listOf(DEFEND, SUPPORT, ATTACK)),
    FALSE_NINE(listOf(SUPPORT))

}