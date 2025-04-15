package ru.mobile.PermTravelServer.handlers

import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.*
import ru.mobile.PermTravelServer.services.ServicePosts
import java.net.URI
import java.util.UUID

@Component
class CHandlerPosts(
    val servicePosts: ServicePosts
) {
    suspend fun getAllByAuthor(
        request: ServerRequest
    ) : ServerResponse
    {
        val authorIdPath = request.pathVariable("authorId")
        val authorId: UUID
        try {
            authorId = UUID.fromString(authorIdPath)
        }
        catch (
            e : Exception
        )
        {
            return ServerResponse.badRequest()
                .bodyValueAndAwait("Параметр id не соответствует формату UUID v4!")
        }
        val res = servicePosts.findAllById(authorId)
        return ServerResponse.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValueAndAwait(res)

    }

    suspend fun createPost(request: ServerRequest): ServerResponse {
        return try {
            val createRequest = request.awaitBody<ServicePosts.CreatePostRequest>()
            val post = servicePosts.createPost(createRequest)

            ServerResponse
                .created(URI.create("/posts/${post.id}"))
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValueAndAwait(post)
        } catch (e: Exception) {
            ServerResponse
                .badRequest()
                .bodyValueAndAwait(mapOf(
                    "error" to "Invalid request data",
                    "details" to e.message
                ))
        }
    }
}