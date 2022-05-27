package com.example.mobileproject2.noteList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.mobileproject2.R
import com.example.mobileproject2.databinding.FragmentNoteListBinding

class NoteListFragment:Fragment(R.layout.fragment_note_list) {

    private var _binding: FragmentNoteListBinding?=null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentNoteListBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding.button.setOnClickListener{

            findNavController().navigate(R.id.action_noteListFragment_to_noteDetailFragment2)
        }


    }
}