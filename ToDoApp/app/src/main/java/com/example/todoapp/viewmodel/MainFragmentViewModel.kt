package com.example.todoapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todoapp.entity.ToDo
import com.example.todoapp.repo.NoteDaoRepository

class MainFragmentViewModel (application: Application) : AndroidViewModel(application) {
    var notelist= MutableLiveData<List<ToDo>>()
    val nrepo=NoteDaoRepository(application)
    init {
    noteUpload()
        notelist=nrepo.getNote()
    }
    fun search (aramaKelimesi:String){
        nrepo.searchNote(aramaKelimesi)
    }
    fun delete(kisi_ıd: Int){
        nrepo.deleteNote(kisi_ıd)
    }
    fun noteUpload(){
        nrepo.getAllNote()
    }
}