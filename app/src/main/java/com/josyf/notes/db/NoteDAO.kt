package com.josyf.notes.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NoteDAO {
    // this func will insert our note into our DB. so we use
    @Insert
    fun addNote(note: Note)

    @Query("SELECT * FROM note")
    fun getAllNotes() : List<Note>

    @Insert
    fun addMultipleNotes(vararg note: Note)
}