package com.example.todoapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.todoapp.repo.NoteDaoRepository

class DetailFragmentViewModel (application: Application) : AndroidViewModel(application) {
   val nrepo=NoteDaoRepository(application)
    fun update(note_ıd:Int,note_ad:String){
        nrepo.updateNote(note_ıd,note_ad)
    }
}