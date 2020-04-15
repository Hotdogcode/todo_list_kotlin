package com.hotdogcode.todolist.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hotdogcode.todolist.utilities.DATABASE_NAME

@Database(entities = [Note::class],version = 1,exportSchema = false)
abstract class AppDatabase : RoomDatabase(){
    abstract fun noteDao():NoteDao

    companion object{
        private var instance : AppDatabase? = null

        fun getInstance (context: Context) =
            instance ?: synchronized(this){
                instance ?: buildDatabase(context).also { instance=it }
            }

        private fun buildDatabase(context: Context):AppDatabase{
            return Room.databaseBuilder(context,AppDatabase::class.java, DATABASE_NAME).build()
        }
    }
}