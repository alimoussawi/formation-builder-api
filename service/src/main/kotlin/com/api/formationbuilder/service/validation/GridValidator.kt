package com.api.formationbuilder.service.validation

import com.api.formationbuilder.model.grid.GridDTO
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext

class GridValidator : ConstraintValidator<ValidGrid, GridDTO> {
    override fun initialize(constraintAnnotation: ValidGrid) {
        super.initialize(constraintAnnotation)
    }

    override fun isValid(grid: GridDTO?, context: ConstraintValidatorContext): Boolean {
        context.disableDefaultConstraintViolation()

        if (grid == null) {
            errorMessage(context, "grid cannot be null")
            return false
        }

        val playersInGrid =
            grid.gridRows
                .flatMap { gridRowDTO -> gridRowDTO.rowPositions }
                .mapNotNull { rowPos -> rowPos.playerId }

        val playersInBench = grid.gridBench.mapNotNull { it.playerId }

        val commonPlayers = playersInGrid.intersect(playersInBench.toSet())

        if (commonPlayers.isNotEmpty()) {
            errorMessage(context, "grid and bench cannot contain same players , players : $commonPlayers")
            return false
        }

        return true
    }

    private fun errorMessage(context: ConstraintValidatorContext, message: String) {
        context.buildConstraintViolationWithTemplate(message).addConstraintViolation()
    }
}