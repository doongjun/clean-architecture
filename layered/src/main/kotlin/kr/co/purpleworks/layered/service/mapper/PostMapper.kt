package kr.co.purpleworks.layered.service.mapper

import kr.co.purpleworks.layered.domain.Post
import kr.co.purpleworks.layered.service.dto.PostDto
import org.springframework.stereotype.Component

@Component
class PostMapper {
    fun mapToDto(
        entity: Post
    ): PostDto {
        return PostDto(
            id = entity.id,
            userId = entity.userId,
            contents = entity.contents
        )
    }

    fun mapToEntity(
        dto: PostDto
    ): Post {
        return Post(
            userId = dto.userId,
            contents = dto.contents
        )
    }
}