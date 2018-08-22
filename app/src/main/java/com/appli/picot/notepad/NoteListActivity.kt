package com.appli.picot.notepad

import android.app.Activity
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
        listNote.adapter = adapter
    }

    override fun onClick(view: View?) {
        if ( view?.tag != null) {
            val index = view.tag as Int
            val note = notes[index]
            Log.i(TAG, note.toString())
            val intent = Intent(this, NoteDetailActivity::class.java)
            intent.putExtra(NoteDetailActivity.NOTE, note)
            intent.putExtra(NoteDetailActivity.INDEX, index)
            startActivityForResult(intent, NoteDetailActivity.REQUEST)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(resultCode != Activity.RESULT_OK || data == null){
            return
        }
        else {
            when(requestCode) {
                NoteDetailActivity.REQUEST -> updateNotes(data)
            }
        }
    }

    private fun updateNotes(data: Intent){
        val noteIndex = data.getIntExtra(NoteDetailActivity.INDEX, -1)
        val note = data.getParcelableExtra<Note>(NoteDetailActivity.NOTE)
        notes[noteIndex] = note
        Log.i(TAG, notes.toString())
        Log.i(TAG+"adaptater", adapter.notes.toString())
        Log.i(TAG, noteIndex.toString())
        adapter.notifyItemChanged(noteIndex)
    }

}
