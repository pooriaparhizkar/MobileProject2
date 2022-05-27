package com.example.mobileproject2

import android.app.Application
import androidx.room.Room
import com.example.mobileproject2.data.local.database.AppDatabase

class BaseApplication : Application() {

    companion object{
        const val DATABASE_NAME="database"
        lateinit var database: AppDatabase
    }
    override fun onCreate() {
        super.onCreate()
        database= Room.databaseBuilder(this.applicationContext,AppDatabase::class.java,
            DATABASE_NAME).allowMainThreadQueries().build()
    }
}