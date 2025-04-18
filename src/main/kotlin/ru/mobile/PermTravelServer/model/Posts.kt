package ru.mobile.PermTravelServer.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.util.*


@Table("posts")
data class Posts(

    @Id
    @Column("id")
    var id : UUID,

    @Column("authorid")
    var authorId : UUID,

    @Column("text")
    var text : String?,

    @Column("createdat")
    var createdAt: Long,

    @Column("placeid")
    var placeId: UUID? = null,


    )
