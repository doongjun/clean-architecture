package kr.co.purpleworks.hexagonal.adapter.out.persistence

import org.springframework.data.jpa.repository.JpaRepository


interface PostRepository : JpaRepository<PostJpaEntity, Long>