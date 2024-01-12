package kr.co.purpleworks.hexagonal.application.domain.service

import kr.co.purpleworks.hexagonal.application.domain.model.Post
import kr.co.purpleworks.hexagonal.application.port.`in`.RegisterPostCommand
import kr.co.purpleworks.hexagonal.application.port.out.LoadPostPort
import kr.co.purpleworks.hexagonal.application.port.out.SavePostPort
import org.junit.jupiter.api.Test
import org.mockito.kotlin.eq
import org.mockito.kotlin.mock
import org.mockito.kotlin.then

class PostServiceTest {
    private val loadPostPort = mock<LoadPostPort>()
    private val savePostPort = mock<SavePostPort>()
    private val postService = PostService(loadPostPort, savePostPort)

    @Test
    fun register() {
        //given
        val command = RegisterPostCommand(1L, "Test")

        //when
        postService.register(command)

        //then
        then(savePostPort).should().savePost(eq(Post(userId = 1L, contents = "Test")))
    }

    @Test
    fun get() {
        //given, when
        postService.get(1L)

        //then
        then(loadPostPort).should().loadPost(eq(1L))
    }
}