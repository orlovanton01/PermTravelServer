package ru.mobile.PermTravelServer.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.Instant
import java.util.*


@Table("posts")
data class Posts(

    @Id
    @Column("id")
    var id : UUID = UUID.randomUUID(),

    @Column("authorid")
    var authorId : UUID,

    @Column("text")
    var text : String?,

    @Column("createdat")
    var createdAt: Long = Instant.now().epochSecond,

    @Column("placeid")
    var placeId: UUID?,


    )
