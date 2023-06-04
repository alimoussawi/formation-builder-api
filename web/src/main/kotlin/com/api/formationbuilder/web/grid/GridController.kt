package com.api.formationbuilder.web.grid

import com.api.formationbuilder.model.grid.GridDTO
import com.api.formationbuilder.model.grid.GridResponseDTO
import com.api.formationbuilder.service.grid.GridService
import com.api.formationbuilder.service.validation.ValidGrid
import com.api.formationbuilder.web.swagger.SwaggerSecurity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/grids")
@Validated
class GridController(private val gridService: GridService) {

    @GetMapping
    @SwaggerSecurity
    fun getGrids(): ResponseEntity<List<GridResponseDTO>> {
        return ResponseEntity.ok(gridService.getGrids())
    }

    @GetMapping("/{id}")
    @SwaggerSecurity
    fun getGrid(@PathVariable id: String): ResponseEntity<GridResponseDTO> {
        return ResponseEntity.ok(gridService.getGrid(id))
    }

    @PostMapping
    @SwaggerSecurity
    fun createEmptyGrid(): ResponseEntity<String> {
        val emptyGrid = gridService.createEmptyGrid()
        return ResponseEntity.status(HttpStatus.CREATED).body(gridService.saveGrid(emptyGrid))
    }

    @PutMapping("/{id}")
    @SwaggerSecurity
    fun updateGrid(@PathVariable id: String, @RequestBody @ValidGrid grid: GridDTO): ResponseEntity<GridResponseDTO> {
        return ResponseEntity.status(HttpStatus.OK).body(gridService.updateGrid(id, grid))
    }
}