package com.example.mobileproject2.noteDetail
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mobileproject2.BaseApplication
import com.example.mobileproject2.R
import com.example.mobileproject2.data.local.mapper.NoteCacheMapper
import com.example.mobileproject2.databinding.FragmentNewNoteBinding
import com.example.mobileproject2.model.Note

class NewNoteFragment:Fragment(R.layout.fragment_new_note) {

    private var _binding: FragmentNewNoteBinding?=null
    private val binding get() = _binding!!
    private val mapper=NoteCacheMapper()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentNewNoteBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.submitNote.setOnClickListener{
            val title:String = binding.titleNote.text.toString()
            val text:String=binding.textNote.text.toString()
            val note=Note(title,text)
            BaseApplication.database.getNoteDao().insert(mapper.mapFrom(note))
            findNavController().navigate(R.id.action_newNoteFragment_to_noteListFragment2)
        }
    }
}