package kr.co.purpleworks.layered.domain

import jakarta.persistence.*

@Entity
@Table(name = "posts")
class Post(
    @Column(nullable = false)
    val userId: Long,
    contents: String
) {
    @Id
    @GeneratedValue
    var id: Long = 0L
        protected set

    @Column(nullable = false)
    var contents: String = contents
        protected set

    fun update(contents: String): Post {
        this.contents = contents
        return this
    }
}