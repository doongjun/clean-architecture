package kr.co.purpleworks.layered.service.dto

data class PostDto(
    val id: Long = 0L,
    val userId: Long,
    val contents: String
)