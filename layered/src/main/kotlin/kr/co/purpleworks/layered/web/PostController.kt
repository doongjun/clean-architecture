package kr.co.purpleworks.layered.web

import kr.co.purpleworks.layered.extension.getCurrentUserId
import kr.co.purpleworks.layered.service.PostService
import kr.co.purpleworks.layered.service.dto.PostDto
import kr.co.purpleworks.layered.web.vm.RegisterPostVm
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/posts")
class PostController(
    private val postService: PostService
) {
    @PostMapping
    fun register(
        @Validated @RequestBody body: RegisterPostVm
    ): Long {
        val dto = PostDto(
            userId = getCurrentUserId(),
            contents = body.contents!!
        )

        return postService.register(dto)
    }

    @GetMapping("/{id}")
    fun get(
        @PathVariable id: Long
    ): PostDto {
        return postService.get(id)
    }
}