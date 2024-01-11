package kr.co.purpleworks.hexagonal.adapter.out.persistence

import jakarta.persistence.*

@Entity
@Table(name = "posts")
class PostJpaEntity(
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

    fun update(contents: String): PostJpaEntity {
        this.contents = contents
        return this
    }
}