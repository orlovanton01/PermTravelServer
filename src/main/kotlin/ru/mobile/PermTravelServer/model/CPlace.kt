package ru.mobile.PermTravelServer.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.util.*


@Table("places")
data class CPlace (
    @Id
    @Column("id")
    var id : UUID,
    @Column("name")
    var name : String,
    @Column("photoPath")
    var photoPath: String,
    @Column("description")
    var description: String,
    @Column("latitude")
    var latitude: Double,
    @Column("longitude")
    var longitude: Double
)