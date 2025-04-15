package ru.mobile.PermTravelServer.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.util.*

@Table("authors")
data class Author(
    @Id
    @Column("id")
    var id : UUID,

    @Column("name")
    var name : String,

    @Column("instagramlink")
    var instagramLink : String,

    @Column("description")
    var description : String,

    @Column("avatar")
    var avatar : String
    )
