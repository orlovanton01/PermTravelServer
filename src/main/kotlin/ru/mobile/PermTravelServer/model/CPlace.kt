package ru.mobile.PermTravelServer.model

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.beans.factory.annotation.Value
import org.springframework.data.annotation.Id
import org.springframework.data.domain.Persistable
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
    var description: String
)