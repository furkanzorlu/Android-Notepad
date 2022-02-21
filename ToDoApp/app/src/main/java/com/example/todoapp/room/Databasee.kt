package com.example.todoapp.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.todoapp.entity.ToDo

@Database(entities = [ToDo::class],version = 1)
abstract  class Databasee :RoomDatabase() {
abstract fun noteDao():NoteDao
  companion object{
      var INSTANCE: Databasee?= null
      fun databaseAccess(context: Context):Databasee?{
          if (INSTANCE==null){
              synchronized(Databasee::class){
                  INSTANCE= Room.databaseBuilder(context.applicationContext,
                      Databasee::class.java,
                      "Notepad.sqlite").createFromAsset("Notepad.sqlite").build()
              }
          }
          return INSTANCE
      }
  }
}