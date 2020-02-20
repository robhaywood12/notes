package com.josyf.notes.db

import androidx.room.Database

@Database(
    entities = [Note::class],
    version = 1
)

abstract class NoteDatabase {
    // now create functions to get our DAOs. we've only got 1 here
    abstract fun getNoteDao() : NoteDAO

    // now to build the room db
    companion object {
        private val instance : NoteDatabase? = null
    }
}