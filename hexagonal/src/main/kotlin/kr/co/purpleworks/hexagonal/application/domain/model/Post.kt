package kr.co.purpleworks.hexagonal.application.domain.model

data class Post(
    val id: Long = 0L,
    val userId: Long,
    var contents: String
) {
    fun update(contents: String): Post {
        this.contents = contents
        return this
    }
}