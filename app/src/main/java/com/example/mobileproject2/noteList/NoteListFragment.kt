package com.example.mobileproject2.noteList

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.mobileproject2.BaseApplication
import com.example.mobileproject2.R
import com.example.mobileproject2.data.local.mapper.NoteCacheMapper
import com.example.mobileproject2.data.local.model.LocalNote
import com.example.mobileproject2.databinding.FragmentNoteListBinding
import com.example.mobileproject2.model.Note
import com.example.mobileproject2.model.ui.note.ItemViewNote
import com.example.mobileproject2.model.ui.note.NoteAdapter

class NoteListFragment:Fragment(R.layout.fragment_note_list) {

    private var _binding: FragmentNoteListBinding?=null
    private val binding get() = _binding!!

    private lateinit var adapter : NoteAdapter
    private val mapper= NoteCacheMapper()

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

        val notes=BaseApplication.database.getNoteDao().getAll()
        adapter= NoteAdapter(notes).apply {
            listener = object : ItemViewNote.Listener {
                override fun onItemClicked(note: LocalNote) {
                    findNavController().navigate(NoteListFragmentDirections.actionNoteListFragmentToNoteDetailFragment2(mapper.convertLocalNoteToNoteWithId(note)))
                }
            }
        }
        binding.recyclerViewCity.adapter=this.adapter


        binding.newNote.setOnClickListener {
            findNavController().navigate(R.id.action_noteListFragment_to_newNoteFragment2)
        }


    }
}