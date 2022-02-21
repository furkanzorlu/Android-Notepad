package com.example.todoapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.R
import com.example.todoapp.databinding.CardRowBinding
import com.example.todoapp.entity.ToDo

import com.example.todoapp.fragment.MainFragmentDirections
import com.example.todoapp.viewmodel.MainFragmentViewModel
import com.google.android.material.snackbar.Snackbar


class NoteAdapter (var mcontext:Context,
                   var notelist:List<ToDo>,
                   var viewModel: MainFragmentViewModel) :
    RecyclerView.Adapter<NoteAdapter.ViewHolder>(){
    inner class  ViewHolder(cardTasarimiBinding:CardRowBinding ):
        RecyclerView.ViewHolder(cardTasarimiBinding.root){

        var cardTasarimiBinding: CardRowBinding

        init {
            this.cardTasarimiBinding=cardTasarimiBinding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater=LayoutInflater.from(mcontext)
        val tasarım=CardRowBinding.inflate(layoutInflater,parent,false,)

        return ViewHolder(tasarım)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
          val note=notelist.get(position)
        val t=holder.cardTasarimiBinding
        t.notenesnesi=note
        t.cardrow.setOnClickListener {
            val intent=MainFragmentDirections.maintodetail(note)
            Navigation.findNavController(it).navigate(intent)
        }
        t.imageViewSilDelete.setOnClickListener {
            Snackbar.make(it,"${note.note_ad} Delete?",Snackbar.LENGTH_LONG)
                .setAction("YES"){
           viewModel.delete(note.note_id)
                }.show()
        }
    }

    override fun getItemCount(): Int {
       return notelist.size
    }
}