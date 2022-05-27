package com.example.mobileproject2.model.ui.note

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileproject2.data.local.mapper.NoteCacheMapper
import com.example.mobileproject2.data.local.model.LocalNote
import com.example.mobileproject2.model.Note

class NoteAdapter(val notes : List<LocalNote>) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    class NoteViewHolder (val itemViewNote: ItemViewNote):RecyclerView.ViewHolder(itemViewNote)

    var listener: ItemViewNote.Listener? = null
    private val mapper= NoteCacheMapper()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(ItemViewNote(parent.context))
    }


    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val item = notes[position]
        holder.itemViewNote.also {
            it.note = item
            it.listener = listener
        }
    }


    override fun getItemCount(): Int = notes.size
}