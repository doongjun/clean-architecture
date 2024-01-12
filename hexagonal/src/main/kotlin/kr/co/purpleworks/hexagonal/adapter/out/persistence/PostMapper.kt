package kr.co.purpleworks.hexagonal.adapter.out.persistence

import kr.co.purpleworks.hexagonal.application.domain.model.Post
import org.springframework.stereotype.Component

@Component
class PostMapper {
    fun mapToDomainEntity(
        post: PostJpaEntity
    ): Post {
        return Post(
            id = post.id,
            userId = post.userId,
            contents = post.contents
        )
    }

    fun mapToJpaEntity(
        post: Post
    ): PostJpaEntity {
        return PostJpaEntity(
            userId = post.userId,
            contents = post.contents
        )
    }
}