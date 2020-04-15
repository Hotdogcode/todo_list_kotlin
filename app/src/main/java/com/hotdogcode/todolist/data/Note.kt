package com.hotdogcode.todolist.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class Note(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val plantId:String,
    val title:String,
    val subTitle:String
){
    override fun toString()= title
}