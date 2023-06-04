package com.api.formationbuilder.web.grid

import com.api.formationbuilder.service.grid.GridService
import com.api.formationbuilder.web.mocks.Mocks
import com.fasterxml.jackson.databind.ObjectMapper
import org.hamcrest.Matchers.hasSize
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.jwt
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import org.hamcrest.Matchers.`is`
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*

@WebMvcTest(controllers = [GridController::class])
class GridControllerTest {
    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    @MockBean
    private lateinit var gridService: GridService

    private val gridsUrl: String = "/api/v1/grids"

    @Test
    fun getGrids_return_one_empty_grid() {
        `when`(gridService.getGrids()).thenReturn(listOf(Mocks.gridResponseDTO_empty_mock()))

        mockMvc.perform(
            get(gridsUrl)
                .with(jwt())
                .contentType("application/json")
        )
            .andDo(print())
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.[0].id", `is`(Mocks.gridResponseDTO_empty_mock().id)))
            .andExpect(jsonPath("$.[0].name", `is`(Mocks.gridResponseDTO_empty_mock().name)))
            .andExpect(jsonPath("$[0].gridRows", hasSize(6), List::class.java))
            .andExpect(jsonPath("$[0].gridBench", hasSize(7), List::class.java))
    }

    @Test
    fun getGrid_return_empty_grid() {
        val gridId = "grid-id"
        `when`(gridService.getGrid(gridId)).thenReturn(Mocks.gridResponseDTO_empty_mock())
        mockMvc.perform(
            get("$gridsUrl/$gridId").with(jwt()).contentType("application/json")
        )
            .andDo(print())
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.id", `is`(Mocks.gridResponseDTO_empty_mock().id)))
            .andExpect(jsonPath("$.name", `is`(Mocks.gridResponseDTO_empty_mock().name)))
            .andExpect(jsonPath("$.gridRows", hasSize(6), List::class.java))
            .andExpect(jsonPath("$.gridBench", hasSize(7), List::class.java))
    }

    @Test
    fun createEmptyGrid() {
        val gridToSave = Mocks.gridDTO_empty_mock()
        `when`(gridService.createEmptyGrid()).thenReturn(gridToSave)
        `when`(gridService.saveGrid(gridToSave))
            .thenReturn("saved-grid-id")

        mockMvc.perform(
            post(gridsUrl)
                .with(jwt())
                .contentType("application/json")
        )
            .andDo(print())
            .andExpect(status().isCreated)
            .andExpect(content().string("saved-grid-id"))
    }

    @Test
    fun updateGrid() {
        `when`(gridService.updateGrid("grid-id", Mocks.gridDTO_empty_mock()))
            .thenReturn(Mocks.gridResponseDTO_empty_mock())

        mockMvc.perform(
            put("$gridsUrl/grid-id")
                .with(jwt())
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(Mocks.gridDTO_empty_mock()))
        )
            .andDo(print())
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.id", `is`(Mocks.gridResponseDTO_empty_mock().id)))
            .andExpect(jsonPath("$.name", `is`(Mocks.gridResponseDTO_empty_mock().name)))
            .andExpect(jsonPath("$.gridRows", hasSize(6), List::class.java))
            .andExpect(jsonPath("$.gridBench", hasSize(7), List::class.java))
    }

    @Test
    fun updateGrid_with_grid_and_bench_contain_duplication_should_fail() {
        mockMvc.perform(
            put("$gridsUrl/grid-id")
                .with(jwt())
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(Mocks.gridDTO_duplication_error_mock()))
        )
            .andDo(print())
            .andExpect(status().`is`(400))
            .andExpect(jsonPath("$.detail", `is`("grid and bench cannot contain same players , players : [PLAYER-ID-1]")))
    }

}