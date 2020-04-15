package com.hotdogcode.todolist.data

class NoteRepo private constructor(private val noteDao: NoteDao){
    fun getAllNotes()=noteDao.getAllNotes()
    fun getNoteById(noteId:String)=noteDao.getNoteById(noteId)
    suspend fun deleteAllNotes()=noteDao.deleteAllNotes()
    suspend fun deleteNoteById(noteId: String)=noteDao.deleteNoteById(noteId)
    suspend fun insertNote(note: Note)=noteDao.insertNote(note)

    companion object
    {
        @Volatile
        private var instance : NoteRepo? = null

        fun getInstance(noteDao: NoteDao) =
            instance ?: synchronized(this){
                instance ?: NoteRepo(noteDao).also { instance=it }
            }
    }

}