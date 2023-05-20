package com.api.formationbuilder.model.constants

enum class Row(val positions: List<Position>) {
    GK_ROW(listOf(Position.GK)),
    DF_ROW(listOf(Position.DL, Position.DC, Position.DC, Position.DC, Position.DR)),
    DM_ROW(listOf(Position.WL, Position.DM, Position.DM, Position.DM, Position.WR)),
    MD_ROW(listOf(Position.LM, Position.CM, Position.CM, Position.CM, Position.RM)),
    AM_ROW(listOf(Position.LW, Position.AM, Position.AM, Position.AM, Position.RW)),
    ST_ROW(listOf(Position.ST, Position.ST, Position.ST))
}