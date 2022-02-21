package com.example.todoapp.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable
@Entity(tableName="note")
data class ToDo(@PrimaryKey(autoGenerate = true)
                @ColumnInfo(name = "note_ıd")@NotNull var note_id:Int,
                @ColumnInfo(name = "note_ad")@NotNull var note_ad:String) : Serializable {
}