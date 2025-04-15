package ru.mobile.PermTravelServer.repositories

import org.springframework.data.r2dbc.repository.Modifying
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.data.repository.query.Param
import ru.mobile.PermTravelServer.model.Posts
import java.util.UUID

interface IRepositoryPosts: CoroutineCrudRepository<Posts, UUID> {
    @Query("SELECT * FROM posts WHERE authorid = :authorId")
    suspend fun findByAuthor(@Param("authorId") authorId: UUID): List<Posts?>

    @Modifying
    @Query("""
        INSERT INTO posts (id, authorid, text, createdat, placeid)
        VALUES (:id, :authorId, :text, :createdAt, :placeId)
    """)
    suspend fun customInsert(id: UUID,
                             authorId: UUID,
                             text: String?,
                             createdAt: Long,
                             placeId: UUID?)
}