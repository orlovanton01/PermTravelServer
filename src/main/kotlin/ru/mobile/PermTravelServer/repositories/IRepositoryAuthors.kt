package ru.mobile.PermTravelServer.repositories

import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import ru.mobile.PermTravelServer.model.Author
import java.util.UUID

interface IRepositoryAuthors: CoroutineCrudRepository<Author, UUID> {
}