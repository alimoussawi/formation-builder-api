package com.api.formationbuilder.web.player

import com.api.formationbuilder.service.player.PlayerService
import com.api.formationbuilder.web.mocks.Mocks
import com.fasterxml.jackson.databind.ObjectMapper
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.jwt
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*


@WebMvcTest(controllers = [PlayerController::class])
class PlayerControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    @MockBean
    private lateinit var playerService: PlayerService

    private val playersUrl: String = "/api/v1/players"

    @Test
    fun getPlayer() {
        `when`(playerService.getPlayers()).thenReturn(listOf(Mocks.playerResponseDTO_mock()))

        mockMvc.perform(
            get(playersUrl)
                .with(jwt())
                .contentType("application/json")
        )
            .andDo(print())
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.[0].id", `is`(Mocks.playerResponseDTO_mock().id)))
            .andExpect(jsonPath("$.[0].name", `is`(Mocks.playerResponseDTO_mock().name)))
    }

    @Test
    fun savePlayer() {
        mockMvc.perform(
            post(playersUrl)
                .contentType("application/json")
                .with(jwt())
                .content(objectMapper.writeValueAsString(Mocks.playerDTO_validMock()))
        )
            .andDo(print())
            .andExpect(status().isCreated)
    }


    @Test
    fun savePlayer_invalid_no_positions_set() {
        mockMvc.perform(
            post(playersUrl)
                .contentType("application/json")
                .with(jwt())
                .content(objectMapper.writeValueAsString(Mocks.playerDTO_invalidMock_no_positions()))
        )
            .andDo(print())
            .andExpect(status().`is`(400))
            .andExpect(jsonPath("$.detail", `is`("player can have between 1 -> 11 familiar positions")))
    }


    @Test
    fun savePlayer_invalid_duplicate_positions() {
        mockMvc.perform(
            post(playersUrl)
                .contentType("application/json")
                .with(jwt())
                .content(objectMapper.writeValueAsString(Mocks.playerDTO_invalidMock_duplicate_positions()))
        )
            .andDo(print())
            .andExpect(status().`is`(400))
            .andExpect(jsonPath("$.detail", `is`("player familiar positions cannot contain duplicates")))
    }

    @Test
    fun savePlayer_invalid_no_roles() {
        mockMvc.perform(
            post(playersUrl)
                .contentType("application/json")
                .with(jwt())
                .content(objectMapper.writeValueAsString(Mocks.playerDTO_invalidMock_no_roles()))
        )
            .andDo(print())
            .andExpect(status().`is`(400))
            .andExpect(jsonPath("$.detail", `is`("position roles cannot be empty")))
    }


    @Test
    fun savePlayer_invalid_duplicate_roles() {
        mockMvc.perform(
            post(playersUrl)
                .contentType("application/json")
                .with(jwt())
                .content(objectMapper.writeValueAsString(Mocks.playerDTO_invalidMock_duplicate_roles()))
        )
            .andDo(print())
            .andExpect(status().`is`(400))
            .andExpect(jsonPath("$.detail", `is`("roles within a position cannot contain duplicates")))
    }

}