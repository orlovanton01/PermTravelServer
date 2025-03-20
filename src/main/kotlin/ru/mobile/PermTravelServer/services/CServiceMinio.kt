package ru.mobile.PermTravelServer.services

import io.minio.GetObjectArgs
import io.minio.MinioClient
import org.springframework.stereotype.Service
import java.io.InputStream

@Service
class CServiceMinIO {

    private val minioClient = MinioClient.builder()
        .endpoint("http://localhost:9000")
        .credentials("minioadmin", "minioadmin")
        .build()

    private val bucketName = "permtravel"

    fun getFile(fileName: String): InputStream? {
        return try {
            minioClient.getObject(
                GetObjectArgs.builder()
                    .bucket(bucketName)
                    .`object`(fileName)
                    .build()
            )
        } catch (e: Exception) {
            null
        }
    }
}
