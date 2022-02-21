package com.example.todoapp.fragment

import android.os.Bundle
import android.view.*

import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todoapp.R
import com.example.todoapp.adapter.NoteAdapter

import com.example.todoapp.databinding.FragmentMainBinding
import com.example.todoapp.entity.ToDo
import com.example.todoapp.viewmodel.MainFragmentViewModel
import com.example.todoapp.viewmodel.MainVMf


class MainFragment : Fragment(), SearchView.OnQueryTextListener {
  private lateinit var binding: FragmentMainBinding
  private lateinit var adapter: NoteAdapter
 private lateinit var viewModel:MainFragmentViewModel



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

      binding=DataBindingUtil.inflate(inflater,R.layout.fragment_main,container,false)
      binding.mainfragment=this
        binding.mainToolbarTitle="Notepad"
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)
      viewModel.notelist.observe(viewLifecycleOwner,{
        adapter= NoteAdapter(requireContext(),it,viewModel)

        binding.noteadapter=adapter

      })


        return binding.root
    }
  fun fabClick(v:View){
    Navigation.findNavController(v).navigate(R.id.maintosave)
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setHasOptionsMenu(true)
      val tempViewModel: MainFragmentViewModel by viewModels(){
          MainVMf(requireActivity().application)
      }
      viewModel=tempViewModel
  }

  override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
    inflater.inflate(R.menu.toolbar_menu,menu)
    val item= menu.findItem(R.id.action_ara)
    val searchView=item.actionView as SearchView
    searchView.setOnQueryTextListener(this)
    super.onCreateOptionsMenu(menu, inflater)
  }
  override fun onQueryTextSubmit(p0: String): Boolean {
   viewModel.search(p0)
    return true
  }

  override fun onQueryTextChange(p0: String): Boolean {
      viewModel.search(p0)
    return true
  }

    override fun onResume() {
        super.onResume()
    viewModel.noteUpload()
    }

}