package com.josyf.notes.ui


import android.os.AsyncTask
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation

import com.josyf.notes.R
import com.josyf.notes.db.Note
import com.josyf.notes.db.NoteDatabase
import kotlinx.android.synthetic.main.fragment_add_note.*
import kotlinx.coroutines.launch

/**
 * A simple [Fragment] subclass.
 */


class AddNoteFragment :BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_note, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        button_save.setOnClickListener{ view ->
            val noteTitle = textTitle.text.toString().trim()
            val noteBody = textMessage.text.toString().trim()

            if (noteTitle.isEmpty()){
                textTitle.error = "Title Required"
                textTitle.requestFocus()
                return@setOnClickListener
            }

            if (noteBody.isEmpty()){
                textMessage.error = "Note Required"
                textMessage.requestFocus()
                return@setOnClickListener
            }

            launch {
                val note = Note(noteTitle, noteBody)
                context?.let{
                    NoteDatabase(it).noteDao().addNote(note)
                    it.toast("Note Saved!")

                    val action = AddNoteFragmentDirections.actionSaveNote()
                    Navigation.findNavController(view).navigate(action)
                }
            }



            // we can't do this bc it'll crash, database access is in the main thread. we must create the function below to fix this
            //NoteDatabase(activity!!).noteDao().addNote(note)

        }
    }





}
