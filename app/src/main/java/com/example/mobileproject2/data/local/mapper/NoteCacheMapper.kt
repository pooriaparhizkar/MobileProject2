package com.example.mobileproject2.data.local.mapper

import com.example.mobileproject2.data.local.model.LocalNote
import com.example.mobileproject2.model.Note
import com.example.mobileproject2.model.NoteWithId

class NoteCacheMapper {

    fun mapFrom(value : Note) : LocalNote = with(value){
        LocalNote(
            title = title,
            text = text,
        )
    }

    fun mapTo(value : LocalNote) : Note = with(value){
        Note(
            title = title,
            text = text,
        )
    }

    fun convertLocalNoteToNoteWithId(value: LocalNote) : NoteWithId = with(value){
        NoteWithId(
            title = title,
            text = text,
            id = id
        )
    }
}