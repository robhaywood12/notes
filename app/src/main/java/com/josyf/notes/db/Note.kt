package com.josyf.notes.db

import androidx.room.Entity
import androidx.room.PrimaryKey

// Firstly, make this a data class.
// This will be our entity. So, we insert @Entity

@Entity
data class Note(
    // define the attributes that we need. We creating our table
    // Let's make our id the primarykey
    val noteTitle: String,
    val noteBody: String
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}

