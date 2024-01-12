package kr.co.purpleworks.hexagonal.adapter.`in`.web

import kr.co.purpleworks.hexagonal.adapter.`in`.web.vm.RegisterPostVm
import kr.co.purpleworks.hexagonal.application.domain.extension.getCurrentUserId
import kr.co.purpleworks.hexagonal.application.domain.model.Post
import kr.co.purpleworks.hexagonal.application.port.`in`.PostUseCase
import kr.co.purpleworks.hexagonal.application.port.`in`.RegisterPostCommand
import kr.co.purpleworks.hexagonal.common.WebAdapter
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@WebAdapter
@RestController
@RequestMapping("/api/v1/posts")
class PostController(
    private val postUseCase: PostUseCase
) {
    @PostMapping
    fun register(
        @Validated @RequestBody body: RegisterPostVm
    ): Long {
        val command = RegisterPostCommand(
            userId = getCurrentUserId(),
            contents = body.contents!!
        )

        return postUseCase.register(command)
    }

    @GetMapping("/{id}")
    fun get(
        @PathVariable id: Long
    ): Post {
        return postUseCase.get(id)
    }
}