package com.api.formationbuilder.service.grid

import com.api.formationbuilder.model.grid.GridDTO
import com.api.formationbuilder.model.grid.GridResponseDTO
import com.api.formationbuilder.persistence.grid.GridRepository
import com.api.formationbuilder.service.exception.GridNotFoundException
import com.api.formationbuilder.service.mappers.toGrid
import com.api.formationbuilder.service.mappers.toGridResponseDTO
import com.api.formationbuilder.service.mappers.toGridRow
import com.api.formationbuilder.service.user.UserService
import org.springframework.stereotype.Service

@Service
class GridService(
    private val gridGenerator: GridGenerator,
    private val gridRepository: GridRepository,
    private val userService: UserService
) {

    fun getGrids(): List<GridResponseDTO> {
        val createdBy = userService.getUserId()

        return gridRepository.findAllByCreatedBy(createdBy)
            .map {
                it.toGridResponseDTO()
            }
            .toList()
    }

    fun getGrid(gridId: String): GridResponseDTO {
        return gridRepository.findById(gridId)
            .map { grid -> grid.toGridResponseDTO() }
            .orElseThrow { GridNotFoundException("grid with id: $gridId not found") }
    }

    fun createEmptyGrid(): GridDTO {
        return gridGenerator.generateEmptyGrid()
    }

    fun saveGrid(gridDTO: GridDTO): String {
        val createdBy = userService.getUserId()

        val grid = gridDTO.toGrid(createdBy)
        return gridRepository.save(grid).id.toString()
    }

    fun updateGrid(id: String, gridDTO: GridDTO): GridResponseDTO {

        val gridToUpdate = gridRepository.findById(id)
            .orElseThrow {
                GridNotFoundException("grid with id: $id not found")
            }

        val gridUpdated = gridToUpdate.copy(
            id = gridToUpdate.id,
            name = gridDTO.name,
            createdBy = gridToUpdate.createdBy,
            gridRows = gridDTO.gridRows.map { gridRowDTO -> gridRowDTO.toGridRow() }
        )

        return gridRepository.save(gridUpdated).toGridResponseDTO()
    }
}