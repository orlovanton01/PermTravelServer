package ru.mobile.PermTravelServer.handlers

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.*
import ru.mobile.PermTravelServer.services.CServicePlaces
import java.util.*

@Component
class CHandlerPlaces (
    val servicePlaces: CServicePlaces
) {
    suspend fun getAll(
        request: ServerRequest
    ) : ServerResponse
    {
        return ServerResponse.ok()
            .json()
            .bodyAndAwait(servicePlaces.findAll())
    }
    suspend fun getById(
        request: ServerRequest
    ) : ServerResponse
    {
        val idStr = request.pathVariable("id")
        val id: UUID
        try {
            id = UUID.fromString(idStr)
        }
        catch (
            e: Exception
        )
        {
            return ServerResponse.badRequest()
                .bodyValueAndAwait("Параметр id не соответствует формату UUID v4!")
        }
        val res = servicePlaces.findById(id)
        res?:run {
            return ServerResponse.notFound()
                .buildAndAwait()
        }
        return ServerResponse.ok()
            .bodyValueAndAwait(res)
    }
}