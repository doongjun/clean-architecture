package kr.co.purpleworks.layered.service

import kr.co.purpleworks.layered.domain.Post
import kr.co.purpleworks.layered.repository.PostRepository
import kr.co.purpleworks.layered.service.dto.PostDto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.repository.findByIdOrNull

@SpringBootTest
class PostServiceTest {
    @Autowired
    private lateinit var postService: PostService
    @Autowired
    private lateinit var postRepository: PostRepository

    @Test
    fun register() {
        //given
        val dto = PostDto(
            userId = 1L,
            contents = "Test"
        )

        //when
        val id = postService.register(dto)

        //then
        val findPost = postRepository.findByIdOrNull(id)
        assertThat(findPost?.userId).isEqualTo(1L)
        assertThat(findPost?.contents).isEqualTo("Test")
    }

    @Test
    fun get() {
        //given
        val post = postRepository.save(Post(1L, "Test"))

        //when
        val dto = postService.get(post.id)

        //then
        assertThat(dto.userId).isEqualTo(1L)
        assertThat(dto.contents).isEqualTo("Test")
    }
}