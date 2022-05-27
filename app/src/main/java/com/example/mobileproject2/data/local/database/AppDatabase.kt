package com.example.mobileproject2.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mobileproject2.data.local.dao.noteDao
import com.example.mobileproject2.data.local.model.LocalNote

@Database(entities = [LocalNote::class], version = 1)
abstract class AppDatabase :RoomDatabase() {

    abstract fun getNoteDao():noteDao
}