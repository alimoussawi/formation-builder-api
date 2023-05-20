package com.api.formationbuilder.model.constants

import com.api.formationbuilder.model.constants.Role.*

enum class Position(val possibleRoles: List<Role>) {

    GK(listOf(SWEEPER_KEEPER, GOAL_KEEPER)),

    // DF ROW
    DL(listOf(FULL_BACK, WING_BACK)),
    DC(listOf(CENTRAL_DEFENDER, BALL_PLAYING_DEFENDER, NO_NONSENSE_DEFENDER)),
    DR(listOf(FULL_BACK, WING_BACK)),

    // DM ROW
    WL(listOf(WING_BACK, COMPLETE_WING_BACK)),
    DM(listOf(HALF_BACK, BALL_WINNING_MIDFIELDER, DEFENSIVE_MIDFIELDER)),
    WR(listOf(WING_BACK, COMPLETE_WING_BACK)),

    // CM ROW
    LM(listOf(WINGER, WIDE_MIDFIELDER, DEFENSIVE_WINGER, INVERTED_WINGER)),
    CM(listOf(DEEP_LYING_PLAYMAKER,BALL_WINNING_MIDFIELDER, CENTRAL_MIDFIELDER, ADVANCED_PLAYMAKER, BOX_TO_BOX_MIDFIELDER, ROAMING_PLAYMAKER, MEZZALA)),
    RM(listOf(WINGER, WIDE_MIDFIELDER, DEFENSIVE_WINGER, INVERTED_WINGER)),

    // AM ROW
    LW(listOf(WINGER, ADVANCED_PLAYMAKER, INSIDE_FORWARD, TREQUARTISTA, RAUMDEUTER)),
    AM(listOf(ADVANCED_PLAYMAKER, ATTACKING_MIDFIELDER, TREQUARTISTA, ENGANCHE, SHADOW_STRIKER)),
    RW(listOf(WINGER, ADVANCED_PLAYMAKER, INSIDE_FORWARD, TREQUARTISTA, RAUMDEUTER)),

    // ST ROW
    ST(listOf(DEEP_LYING_FORWARD, ADVANCED_FORWARD, TARGET_MAN, POACHER, COMPLETE_FORWARD, PRESSING_FORWARD, FALSE_NINE));

}