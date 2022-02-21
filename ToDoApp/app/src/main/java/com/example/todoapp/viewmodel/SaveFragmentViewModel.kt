package com.example.todoapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.todoapp.repo.NoteDaoRepository

class SaveFragmentViewModel (application: Application) : AndroidViewModel(application) {
    val nrepo= NoteDaoRepository(application)
    fun save(note_ad:String){
        nrepo.saveNote(note_ad)
    }
}