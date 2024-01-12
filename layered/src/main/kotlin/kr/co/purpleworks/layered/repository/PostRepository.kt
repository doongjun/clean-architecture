package kr.co.purpleworks.layered.repository

import kr.co.purpleworks.layered.domain.Post
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PostRepository : JpaRepository<Post, Long>