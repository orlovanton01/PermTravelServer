package ru.mobile.PermTravelServer.services


import org.springframework.stereotype.Service
import ru.mobile.PermTravelServer.model.Posts
import ru.mobile.PermTravelServer.repositories.IRepositoryPosts
import java.util.UUID

@Service
class ServicePosts (
    val repository: IRepositoryPosts
){
    suspend fun findAllById(authorId: UUID): List<Posts?> =
        repository.findByAuthor(authorId)

    suspend fun createPost(request: CreatePostRequest): Posts {
        val newPost =
            Posts(
                authorId = request.authorId,
                text = request.text,
                placeId = request.placeId
            )
        repository.customInsert(
            id = newPost.id,
            authorId = newPost.authorId,
            text = newPost.text,
            createdAt = newPost.createdAt,
            placeId = newPost.placeId
        )
        return newPost
    }

    data class CreatePostRequest(
        val authorId: UUID,
        val text: String?,
        val placeId: UUID? = null
    )
}