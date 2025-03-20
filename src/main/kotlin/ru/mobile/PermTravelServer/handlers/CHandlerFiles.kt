package ru.mobile.PermTravelServer.handlers

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.core.io.InputStreamResource
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyValueAndAwait
import ru.mobile.PermTravelServer.services.CServiceMinIO

@Component
class CHandlerFiles (
    private val minioService: CServiceMinIO
) {
    suspend fun getById(request: ServerRequest): ServerResponse {
        val idStr = request.pathVariable("id")

        val pngFilename = "files/$idStr.png"
        val jpgFilename = "files/$idStr.jpg"

        val (filename, contentType) = withContext(Dispatchers.IO) {
            listOf(pngFilename to MediaType.IMAGE_PNG, jpgFilename to MediaType.IMAGE_JPEG)
                .firstOrNull { minioService.getFile(it.first) != null }
        } ?: return ServerResponse.status(404).bodyValueAndAwait("Файл не найден")

        val fileStream = minioService.getFile(filename) ?: return ServerResponse.status(404).bodyValueAndAwait("Файл не найден")

        val inputStreamResource = InputStreamResource(fileStream)

        return ServerResponse.ok()
            .contentType(contentType)
            .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"$filename\"")
            .bodyValueAndAwait(inputStreamResource)
    }

}
