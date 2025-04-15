package ru.mobile.PermTravelServer.services

import kotlinx.coroutines.flow.Flow
import org.springframework.stereotype.Service
import ru.mobile.PermTravelServer.model.Author
import ru.mobile.PermTravelServer.repositories.IRepositoryAuthors
import java.util.*

@Service
class ServiceAuthors(
    val repository: IRepositoryAuthors
) {
    suspend fun findAll(): Flow<Author> =
        repository.findAll()

    suspend fun findById(id: UUID): Author? =
        repository.findById(id)
}