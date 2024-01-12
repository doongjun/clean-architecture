package kr.co.purpleworks.hexagonal.adapter.`in`.web

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import kr.co.purpleworks.hexagonal.adapter.`in`.web.vm.RegisterPostVm
import kr.co.purpleworks.hexagonal.application.port.`in`.PostUseCase
import kr.co.purpleworks.hexagonal.application.port.`in`.RegisterPostCommand
import org.junit.jupiter.api.Test
import org.mockito.kotlin.eq
import org.mockito.kotlin.then
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(controllers = [PostController::class])
class PostControllerTest {
    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var postUseCase: PostUseCase

    @Test
    fun register() {
        //given
        val body = RegisterPostVm("Test")

        //when, then
        mockMvc.perform(
            post("/api/v1/posts")
                .header("Content-Type", "application/json")
                .content(jacksonObjectMapper().writeValueAsString(body))
        )
            .andExpect(status().isOk())


        then(postUseCase).should()
            .register(eq(RegisterPostCommand(1L, "Test")))
    }

    @Test
    fun get() {
        //given, when, then
        mockMvc.perform(
            get("/api/v1/posts/{id}", 1L)
                .header("Content-Type", "application/json")
        )
            .andExpect(status().isOk())

        then(postUseCase).should()
            .get(eq(1L))
    }
}