package com.appli.picot.notepad

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class NoteAdapter (val notes: ArrayList<Note>, val context: Context) : RecyclerView.Adapter<NoteAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val titre = itemView.findViewById<TextView>(R.id.title_item_list_note)
        val texte = itemView.findViewById<TextView>(R.id.text_item_list_note)
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): NoteAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val viewItem = inflater.inflate(R.layout.item_list_note, parent, false)
        return ViewHolder(viewItem)
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = notes[position]
        holder.titre.text = note.titre
        holder.texte.text = note.texte
    }
}