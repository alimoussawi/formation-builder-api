package com.api.formationbuilder.service.validation

import com.api.formationbuilder.model.player.PlayerDTO
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext

class PlayerValidator : ConstraintValidator<ValidPlayer, PlayerDTO> {
    override fun initialize(constraintAnnotation: ValidPlayer) {
        super.initialize(constraintAnnotation)
    }

    override fun isValid(player: PlayerDTO?, context: ConstraintValidatorContext): Boolean {
        context.disableDefaultConstraintViolation()

        if (player == null) {
            errorMessage(context, "player cannot be null")
            return false
        }

        return validatePositionRoleRelation(context, player)

    }

    /**
    invalid position will be caught early at the converter level
    here we are checking the underlying of a position
     */
    private fun validatePositionRoleRelation(context: ConstraintValidatorContext, player: PlayerDTO): Boolean {
        player.familiarPositions.forEach { playerPositionDTO ->
            val possiblePositionRoles = playerPositionDTO.position.possibleRoles
            playerPositionDTO.familiarRoles.forEach { playerRoleDTO ->
                if (!possiblePositionRoles.contains(playerRoleDTO.role)) {
                    errorMessage(
                        context,
                        message = "role : ${playerRoleDTO.role} is not valid role for position: ${playerPositionDTO.position}"
                    )
                    return false
                }

                val possibleRoleDuties = playerRoleDTO.role.possibleDuties
                playerRoleDTO.familiarDuties.forEach { playerRoleDuty ->
                    if (!possibleRoleDuties.contains(playerRoleDuty)) {
                        errorMessage(
                            context,
                            message = "duty : $playerRoleDuty is not valid duty for role: ${playerRoleDTO.role}"
                        )
                        return false
                    }
                }
            }
        }
        return true
    }


    private fun errorMessage(context: ConstraintValidatorContext, message: String) {
        context.buildConstraintViolationWithTemplate(message).addConstraintViolation()
    }

}