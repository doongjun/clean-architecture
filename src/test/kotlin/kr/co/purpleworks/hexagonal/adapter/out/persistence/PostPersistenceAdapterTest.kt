package kr.co.purpleworks.hexagonal.adapter.out.persistence

import kr.co.purpleworks.hexagonal.application.domain.model.Post
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.Import
import org.springframework.data.repository.findByIdOrNull

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(PostPersistenceAdapter::class, PostMapper::class)
class PostPersistenceAdapterTest {
    @Autowired
    private lateinit var postPersistenceAdapter: PostPersistenceAdapter
    @Autowired
    private lateinit var postRepository: PostRepository

    @Test
    fun loadPost() {
        //given
        val postJpaEntity = postRepository.save(PostJpaEntity(1L, "Test"))

        //when
        val post = postPersistenceAdapter.loadPost(postJpaEntity.id)

        //then
        assertThat(post.userId).isEqualTo(1L)
        assertThat(post.contents).isEqualTo("Test")
    }

    @Test
    fun savePost() {
        //given
        val post = Post(userId = 1L, contents = "Test")

        //when
        val postId = postPersistenceAdapter.savePost(post)

        //then
        val findPost = postRepository.findByIdOrNull(postId)
        assertThat(findPost?.userId).isEqualTo(1L)
        assertThat(findPost?.contents).isEqualTo("Test")
    }
}