package kr.co.purpleworks.hexagonal.adapter.out.persistence

import jakarta.persistence.EntityNotFoundException
import kr.co.purpleworks.hexagonal.application.domain.model.Post
import kr.co.purpleworks.hexagonal.application.port.out.LoadPostPort
import kr.co.purpleworks.hexagonal.application.port.out.SavePostPort
import kr.co.purpleworks.hexagonal.common.PersistenceAdapter
import org.springframework.data.repository.findByIdOrNull

@PersistenceAdapter
class PostPersistenceAdapter(
    private val postRepository: PostRepository,
    private val postMapper: PostMapper
) : LoadPostPort, SavePostPort {
    override fun loadPost(id: Long): Post {
        val post = postRepository.findByIdOrNull(id)
            ?: throw EntityNotFoundException()

        return postMapper.mapToDomainEntity(post)
    }

    override fun savePost(post: Post): Long {
        val postJpaEntity = if (post.id == 0L) {
            postMapper.mapToJpaEntity(post)
        } else {
            postRepository.findByIdOrNull(post.id)
                ?.update(post.contents)
                ?: throw EntityNotFoundException()
        }

        return postRepository.save(postJpaEntity).id
    }
}