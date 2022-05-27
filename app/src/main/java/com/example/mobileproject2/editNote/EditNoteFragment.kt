package com.example.mobileproject2.noteDetail
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.mobileproject2.BaseApplication
import com.example.mobileproject2.R
import com.example.mobileproject2.data.local.mapper.NoteCacheMapper
import com.example.mobileproject2.databinding.FragmentEditNoteBinding
import com.example.mobileproject2.databinding.FragmentNewNoteBinding
import com.example.mobileproject2.model.Note

class EditNoteFragment:Fragment(R.layout.fragment_edit_note) {

    private var _binding: FragmentEditNoteBinding?=null
    private val binding get() = _binding!!
    private val mapper=NoteCacheMapper()
    private val args : EditNoteFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentEditNoteBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.titleEditNote.setText(args.note.title)
        binding.textEditNote.setText(args.note.text)


        binding.submitNote.setOnClickListener{
            val title:String = binding.titleEditNote.text.toString()
            val text:String=binding.textEditNote.text.toString()
            BaseApplication.database.getNoteDao().updateNote(args.note.id,title,text)
            findNavController().navigate(R.id.action_editNoteFragment_to_noteListFragment)
        }
    }
}