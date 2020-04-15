package com.hotdogcode.todolist.utilities

import android.content.Context
import com.hotdogcode.todolist.data.AppDatabase
import com.hotdogcode.todolist.data.NoteRepo

object InjectorUtils {
    private fun getNoteRepo(context: Context):NoteRepo{
        return NoteRepo.getInstance(AppDatabase.getInstance(context).noteDao())
    }
}