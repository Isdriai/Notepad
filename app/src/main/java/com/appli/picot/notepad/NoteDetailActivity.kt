package com.appli.picot.notepad

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class NoteDetailActivity : AppCompatActivity() {

    val TAG = NoteDetailActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_detail)

        val note = intent.getParcelableExtra<Note>("note")
        val texte = findViewById<TextView>(R.id.text_detail_note)
        val titre = findViewById<TextView>(R.id.title_detail_note)

        texte.text = note.corps
        titre.text = note.titre
    }


}
