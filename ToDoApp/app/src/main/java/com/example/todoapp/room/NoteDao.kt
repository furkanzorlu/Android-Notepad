package com.example.todoapp.room

import androidx.room.*
import com.example.todoapp.entity.ToDo

@Dao
interface NoteDao {
    @Query("SELECT * FROM note")
    suspend fun getNote() : List<ToDo>
    @Insert
    suspend fun addNote(note:ToDo)
    @Update
    suspend fun updateNote(note:ToDo)
    @Delete
    suspend fun deleteNote(note:ToDo)
    @Query("SELECT * FROM note WHERE note_ad like '%'|| :aramaKelimesi || '%' ")
    suspend fun searchNote(aramaKelimesi:String) : List<ToDo>
}