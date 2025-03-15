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
    @get:JvmName("_id")
    @get:JvmSynthetic
    var id : UUID?,
    @Column("name")
    var name : String?,
    @Column("photoPath")
    var photoPath: String?,
    @Column("description")
    var description: String?,

    @JsonIgnore //Не надо выгружать/считывать в json
    @org.springframework.data.annotation.Transient //не надо сохранять в БД
    @Value("null") //Не надо заполнять при загрузке из БД
    var new: Boolean?
    = false

) : Persistable<UUID>
{
    override fun getId() = id
    @JsonIgnore
    override fun isNew() = new?:true
}