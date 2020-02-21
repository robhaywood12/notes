package com.josyf.notes.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NoteDAO {
    // this func will insert our note into our DB. so we use
    @Insert
    suspend fun addNote(note: Note)

    @Query("SELECT * FROM note ORDER BY id DESC")
    suspend fun getAllNotes() : List<Note>


    @Insert
    suspend fun addMultipleNotes(vararg note: Note)

    @Delete
    suspend fun delete(note: Note)
}