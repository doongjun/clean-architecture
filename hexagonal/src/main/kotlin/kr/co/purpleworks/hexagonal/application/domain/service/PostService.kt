package kr.co.purpleworks.hexagonal.application.domain.service

import kr.co.purpleworks.hexagonal.application.domain.model.Post
import kr.co.purpleworks.hexagonal.application.port.`in`.PostUseCase
import kr.co.purpleworks.hexagonal.application.port.`in`.RegisterPostCommand
import kr.co.purpleworks.hexagonal.application.port.out.LoadPostPort
import kr.co.purpleworks.hexagonal.application.port.out.SavePostPort
import kr.co.purpleworks.hexagonal.common.UseCase
import org.springframework.transaction.annotation.Transactional

@UseCase
@Transactional
class PostService(
    private val loadPostPort: LoadPostPort,
    private val savePostPort: SavePostPort
) : PostUseCase {
    override fun register(command: RegisterPostCommand): Long {
        val post = Post(userId = command.userId, contents = command.contents)

        return savePostPort.savePost(post)
    }

    @Transactional(readOnly = true)
    override fun get(id: Long): Post {
        return loadPostPort.loadPost(id)
    }
}