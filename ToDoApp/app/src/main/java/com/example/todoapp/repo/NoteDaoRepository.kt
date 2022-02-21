package com.example.todoapp.repo

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.todoapp.entity.ToDo
import com.example.todoapp.room.Databasee
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteDaoRepository(var application: Application)  {
    var notelist:MutableLiveData<List<ToDo>>
    var vb : Databasee
    init {
        notelist= MutableLiveData()
        vb=Databasee.databaseAccess(application) !!
    }
    fun getNote():MutableLiveData<List<ToDo>>{
        return notelist
    }
    fun saveNote(note_ad:String){
      val job= CoroutineScope(Dispatchers.Main).launch {
          val newNote=ToDo(0,note_ad)
          vb.noteDao().addNote(newNote)
      }
    }
    fun updateNote(note_ıd:Int,note_ad: String){
   val job= CoroutineScope(Dispatchers.Main).launch {
       val updatedNote=ToDo(note_ıd,note_ad)
       vb.noteDao().updateNote(updatedNote)
   }
    }
    fun searchNote(searchWord:String){
        val job= CoroutineScope(Dispatchers.Main).launch {
            notelist.value=vb.noteDao().searchNote(searchWord)
        }
    }
    fun deleteNote(note_ıd: Int){
    val job= CoroutineScope(Dispatchers.Main).launch {
val deletedNote=ToDo(note_ıd,"")
        vb.noteDao().deleteNote(deletedNote)
        getAllNote()
    }
    }
    fun getAllNote(){
        val job= CoroutineScope(Dispatchers.Main).launch {
            notelist.value=vb.noteDao().getNote()
        }
    }
}