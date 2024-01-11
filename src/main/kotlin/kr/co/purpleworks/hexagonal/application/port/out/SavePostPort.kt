package kr.co.purpleworks.hexagonal.application.port.out

import kr.co.purpleworks.hexagonal.application.domain.model.Post

interface SavePostPort {
    fun savePost(post: Post): Long
}