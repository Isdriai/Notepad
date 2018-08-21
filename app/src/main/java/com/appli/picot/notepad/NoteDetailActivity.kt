package com.appli.picot.notepad

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class NoteDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_detail)

        val note = intent.getParcelableExtra<Note>("note")
        val texte = findViewById<TextView>(R.id.text_item_list_note)
        val titre = findViewById<TextView>(R.id.title_item_list_note)

        texte.text = note.texte
        titre.text = note.titre
    }
}
