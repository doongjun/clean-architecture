package kr.co.purpleworks.hexagonal.application.port.out

import kr.co.purpleworks.hexagonal.application.domain.model.Post

interface LoadPostPort {
    fun loadPost(id: Long): Post
}