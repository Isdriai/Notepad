package com.appli.picot.notepad

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View

class NoteListActivity : AppCompatActivity(), View.OnClickListener {

    val notes = arrayListOf<Note>()

    val adapter = NoteAdapter(notes, this)

    val TAG = NoteListActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_list)

        readNotes(notes)

        Log.i(TAG, notes.toString())

        val listNote = findViewById<RecyclerView>(R.id.listNote)
        listNote.layoutManager = LinearLayoutManager(this)
        listNote.adapter = NoteAdapter(notes, this)
    }

    override fun onClick(view: View?) {
        if ( view?.tag != null){
            val note = notes[view?.tag as Int]
            Log.i(TAG, note.toString())
            val intent = Intent(this, NoteDetailActivity::class.java)
            intent.putExtra("note", note)
            startActivity(intent)
        }

    }
}
