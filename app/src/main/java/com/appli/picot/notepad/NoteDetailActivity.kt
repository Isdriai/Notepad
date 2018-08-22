package com.appli.picot.notepad

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView

class NoteDetailActivity : AppCompatActivity() {

    val TAG = NoteDetailActivity::class.java.simpleName

    var indexNote = -1

    lateinit var note: Note

    lateinit var texte: TextView
    lateinit var titre: TextView

    companion object {
        val REQUEST = 1
        val NOTE = "note"
        val INDEX = "index"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_detail)

        note = intent.getParcelableExtra<Note>(NOTE)
        indexNote = intent.getIntExtra(INDEX, indexNote)
        texte = findViewById<TextView>(R.id.text_detail_note)
        titre = findViewById<TextView>(R.id.title_detail_note)

        texte.text = note.corps
        titre.text = note.titre
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.note_detail_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            R.id.add -> {
                note.titre = titre.text.toString()
                note.corps = texte.text.toString()

                intent = Intent()
                intent.putExtra(NOTE, note)
                intent.putExtra(INDEX, indexNote)
                setResult(Activity.RESULT_OK, intent)
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
