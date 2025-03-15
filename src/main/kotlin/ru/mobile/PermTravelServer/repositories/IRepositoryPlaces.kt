package ru.mobile.PermTravelServer.repositories

import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import ru.mobile.PermTravelServer.model.CPlace
import java.util.UUID

interface IRepositoryPlaces: CoroutineCrudRepository<CPlace, UUID> {
}