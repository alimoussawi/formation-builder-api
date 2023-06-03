package com.api.formationbuilder.web.mocks

import com.api.formationbuilder.model.constants.Duty
import com.api.formationbuilder.model.constants.Position
import com.api.formationbuilder.model.constants.Role
import com.api.formationbuilder.model.constants.Row
import com.api.formationbuilder.model.grid.GridDTO
import com.api.formationbuilder.model.grid.GridResponseDTO
import com.api.formationbuilder.model.grid.GridRowDTO
import com.api.formationbuilder.model.player.PlayerDTO
import com.api.formationbuilder.model.player.PlayerResponseDTO
import com.api.formationbuilder.model.position.GridPositionDTO
import com.api.formationbuilder.model.position.PlayerPositionDTO
import com.api.formationbuilder.model.role.PlayerRoleDTO

class Mocks {

    companion object {
        // player mocks
        fun playerResponseDTO_mock(): PlayerResponseDTO {
            return PlayerResponseDTO(
                "player-id",
                "player-mock",
                15,
                listOf(playerPositionDTO_DM_1(), playerPositionDTO_CM())
            )
        }

        fun playerDTO_validMock(): PlayerDTO {
            return PlayerDTO("player-mock", 15, listOf(playerPositionDTO_DM_1(), playerPositionDTO_CM()))
        }

        fun playerDTO_invalidMock_no_positions(): PlayerDTO {

            return PlayerDTO("player-mock", 15, listOf())
        }


        fun playerDTO_invalidMock_duplicate_positions(): PlayerDTO {

            return PlayerDTO("player-mock", 15, listOf(playerPositionDTO_DM_1(), playerPositionDTO_DM_2()))
        }

        fun playerDTO_invalidMock_no_roles(): PlayerDTO {

            return PlayerDTO("player-mock", 15, listOf(playerPositionDTO_CM_no_roles()))
        }

        fun playerDTO_invalidMock_duplicate_roles(): PlayerDTO {
            return PlayerDTO("player-mock", 15, listOf(playerPositionDTO_CM_duplicate_roles()))
        }


        fun playerPositionDTO_DM_1(): PlayerPositionDTO {
            return PlayerPositionDTO(
                Position.DM, listOf(
                    PlayerRoleDTO(Role.DEFENSIVE_MIDFIELDER, listOf(Duty.SUPPORT)),
                    PlayerRoleDTO(Role.HALF_BACK, listOf(Duty.DEFEND))
                )
            )
        }


        fun playerPositionDTO_DM_2(): PlayerPositionDTO {
            return PlayerPositionDTO(
                Position.DM, listOf(
                    PlayerRoleDTO(Role.BALL_WINNING_MIDFIELDER, listOf(Duty.DEFEND)),
                    PlayerRoleDTO(Role.HALF_BACK, listOf(Duty.DEFEND))
                )
            )
        }

        fun playerPositionDTO_CM(): PlayerPositionDTO {
            return PlayerPositionDTO(
                Position.CM, listOf(
                    PlayerRoleDTO(Role.ADVANCED_PLAYMAKER, listOf(Duty.SUPPORT)),
                    PlayerRoleDTO(Role.DEEP_LYING_PLAYMAKER, listOf(Duty.DEFEND))
                )
            )
        }

        fun playerPositionDTO_CM_no_roles(): PlayerPositionDTO {
            return PlayerPositionDTO(
                Position.CM, listOf()
            )
        }

        fun playerPositionDTO_CM_duplicate_roles(): PlayerPositionDTO {
            return PlayerPositionDTO(
                Position.CM, listOf(
                    PlayerRoleDTO(Role.DEEP_LYING_PLAYMAKER, listOf(Duty.SUPPORT)),
                    PlayerRoleDTO(Role.DEEP_LYING_PLAYMAKER, listOf(Duty.DEFEND, Duty.SUPPORT))
                )
            )
        }

        // grid mocks

        val EMPTY_GRID_ROWS = Row.values().map { row ->
            GridRowDTO(
                index = row.ordinal,
                name = row.name,
                rowPositions = row.positions.mapIndexed { index, rowPosition ->
                    GridPositionDTO(
                        index,
                        rowPosition,
                        null
                    )
                }
            )
        }

        fun gridResponseDTO_empty_mock(): GridResponseDTO {
            return GridResponseDTO(
                "grid-id",
                "grid-name",
                EMPTY_GRID_ROWS
            )
        }

        fun gridDTO_empty_mock(): GridDTO {
            return GridDTO(
                "grid-name",
                EMPTY_GRID_ROWS
            )
        }
    }
}