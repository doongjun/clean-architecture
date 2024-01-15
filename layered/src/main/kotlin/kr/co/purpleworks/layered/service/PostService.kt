package kr.co.purpleworks.layered.service

import jakarta.persistence.EntityNotFoundException
import kr.co.purpleworks.layered.domain.Post
import kr.co.purpleworks.layered.repository.PostRepository
import kr.co.purpleworks.layered.service.dto.PostDto
import kr.co.purpleworks.layered.service.mapper.PostMapper
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class PostService(
    private val postRepository: PostRepository,
    private val postMapper: PostMapper
) {
    fun register(dto: PostDto): Long {
        val post: Post = postRepository.save(postMapper.mapToEntity(dto))

        return post.id
    }

    @Transactional(readOnly = true)
    fun get(id: Long): PostDto {
        val post: Post = postRepository.findByIdOrNull(id)
            ?: throw EntityNotFoundException()

        return postMapper.mapToDto(post)
    }
}