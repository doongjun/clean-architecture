package kr.co.purpleworks.hexagonal.application.port.`in`

import kr.co.purpleworks.hexagonal.application.domain.model.Post

interface PostUseCase {
    fun register(command: RegisterPostCommand): Long
    fun get(id: Long): Post
}