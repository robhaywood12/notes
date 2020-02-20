package com.josyf.notes.db

import androidx.room.Entity
import androidx.room.PrimaryKey

// Firstly, make this a data class.
// This will be our entity. So, we insert @Entity

@Entity
data class Note(
    // define the attributes that we need. We creating our table
    // Let's make our id the primarykey
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val note: String

)