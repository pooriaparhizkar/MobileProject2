package com.example.mobileproject2.model.ui.note

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.mobileproject2.data.local.model.LocalNote
import com.example.mobileproject2.databinding.ItemViewNoteBinding
import com.example.mobileproject2.model.Note

class ItemViewNote @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : ConstraintLayout(context, attrs) {

    private var _binding : ItemViewNoteBinding? = null
    val binding get() = _binding!!

    var note : LocalNote? = null
        set(value) {
            field=value
            note?.let { note ->
                binding.textNoteTitle.text=note.title
                binding.textNoteText.text=note.text

            }
        }
    var listener : Listener? = null

    init {
        _binding = ItemViewNoteBinding.inflate(LayoutInflater.from(context),this,true)
        binding.root.setOnClickListener {
            note?.let { note ->
                listener?.onItemClicked(note)
            }
        }
    }

    interface Listener {
        fun onItemClicked(note : LocalNote)
    }
}