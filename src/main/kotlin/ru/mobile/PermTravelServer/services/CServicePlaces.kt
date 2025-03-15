package ru.mobile.PermTravelServer.services

import kotlinx.coroutines.flow.Flow
import org.springframework.stereotype.Service
import ru.mobile.PermTravelServer.model.CPlace
import ru.mobile.PermTravelServer.repositories.IRepositoryPlaces
import java.util.UUID

@Service
class CServicePlaces (
    val repository: IRepositoryPlaces
) {
    suspend fun findById(id: UUID): CPlace? =
        repository.findById(id)

    suspend fun findAll(): Flow<CPlace> =
        repository.findAll()
}