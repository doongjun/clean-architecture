package kr.co.purpleworks.hexagonal.application.domain.model

class Post(
    val id: Long = 0L,
    val userId: Long,
    val contents: String
)