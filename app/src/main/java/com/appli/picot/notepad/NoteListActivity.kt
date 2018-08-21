package com.appli.picot.notepad

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

class NoteListActivity : AppCompatActivity() {

    val notes = arrayListOf<Note>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_list)

        readNotes(notes)
        val listNote = findViewById<RecyclerView>(R.id.listNote)
        listNote.layoutManager = LinearLayoutManager(this)
        listNote.adapter = NoteAdapter(notes, this)
    }
}
