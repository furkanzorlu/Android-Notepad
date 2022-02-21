package com.example.todoapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.todoapp.R
import com.example.todoapp.databinding.FragmentDetailBinding
import com.example.todoapp.viewmodel.DetailFragmentViewModel
import com.example.todoapp.viewmodel.DetailVMF

class DetailFragment : Fragment() {
      private lateinit var binding: FragmentDetailBinding
      private lateinit var viewModel:DetailFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_detail, container, false)
        binding.detailfragment=this
        binding.detailfragmenttoolbartitle="Note Detail"

        val bundle: DetailFragmentArgs by navArgs()
        val getNote = bundle.note
       binding.noteNesnesi=getNote


        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:DetailFragmentViewModel by viewModels() {
            DetailVMF(requireActivity().application)
        }
        viewModel=tempViewModel
    }
        fun buttonUpdate(note_ıd:Int,note_ad:String){
        viewModel.nrepo.updateNote(note_ıd,note_ad)
        }

}