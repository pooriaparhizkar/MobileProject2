package com.example.mobileproject2.model

import java.io.Serializable

data class NoteWithId (
    var id:Int?,
    val title:String,
    val text:String
) : Serializable