package ru.mobile.PermTravelServer.services

import io.minio.GetObjectArgs
import io.minio.MinioClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.io.InputStream

@Service
class CServiceMinIO(
    @Value("\${minio.endpoint}") private val endpoint: String,
    @Value("\${minio.access-key}") private val accessKey: String,
    @Value("\${minio.secret-key}") private val secretKey: String,
    @Value("\${minio.bucket}") private val bucketName: String
) {

    private val minioClient = MinioClient.builder()
        .endpoint(endpoint)
        .credentials(accessKey, secretKey)
        .build()

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
