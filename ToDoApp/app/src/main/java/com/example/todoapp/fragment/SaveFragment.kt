package com.example.todoapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels


import com.example.todoapp.R
import com.example.todoapp.databinding.FragmentSaveBinding
import com.example.todoapp.viewmodel.SaveFragmentViewModel
import com.example.todoapp.viewmodel.SaveVMF


class SaveFragment : Fragment() {
     private lateinit var binding: FragmentSaveBinding
    private lateinit var viewModel:SaveFragmentViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_save,container,false)
        binding.savefragment=this
        binding.savefragmenttoolbartitle="Save"

        return binding.root

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : SaveFragmentViewModel by viewModels(){
            SaveVMF(requireActivity().application)
        }
        viewModel=tempViewModel
    }
    fun buttonSave(note:String){
        viewModel.nrepo.saveNote(note)


    }



}