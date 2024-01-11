package kr.co.purpleworks.hexagonal.application.port.`in`

data class RegisterPostCommand(
    val userId: Long,
    val contents: String
)