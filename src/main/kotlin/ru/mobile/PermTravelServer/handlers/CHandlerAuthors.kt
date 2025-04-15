package ru.mobile.PermTravelServer.handlers

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.*
import ru.mobile.PermTravelServer.services.ServiceAuthors
import java.util.UUID

@Component
class CHandlerAuthors(
    val serviceAuthors: ServiceAuthors
) {
    suspend fun getAll(
        request: ServerRequest
    ) : ServerResponse
    {
        return ServerResponse.ok()
            .json()
            .bodyAndAwait(serviceAuthors.findAll())
    }

    suspend fun getById(
        request: ServerRequest
    ): ServerResponse
    {
        val idPath = request.pathVariable("id")
        val id: UUID
        try {
            id = UUID.fromString(idPath)
        }
        catch (
            e: Exception
        )
        {
            return ServerResponse.badRequest()
                .bodyValueAndAwait("Параметр id не соответствует формату UUID v.4 ")
        }
        val res = serviceAuthors.findById(id)
        res?:run {
            return ServerResponse.notFound()
                .buildAndAwait()
        }
        return ServerResponse.ok()
            .bodyValueAndAwait(res)
    }
}