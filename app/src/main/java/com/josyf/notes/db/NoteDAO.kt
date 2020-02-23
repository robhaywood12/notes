package com.josyf.notes.db

import androidx.room.*

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

    @Update
    suspend fun updateNote(note: Note)
}