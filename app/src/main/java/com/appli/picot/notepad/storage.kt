package com.appli.picot.notepad

import android.content.Context
import android.util.Log
import java.io.*
import java.lang.System.out
import java.util.*

val NOTE = "Note"
val EXT = ".txt"

val TAG = "storage"

fun readNotes(listNotes: TreeMap<Int, Note>, context: Context){
    val dir = context.filesDir
   for (file in dir.listFiles()) {
        if (file.isFile and (NOTE in file.name) and (EXT in file.name)) {
            val id = file.name.replace(NOTE, "").replace(EXT, "")
            val out = ObjectInputStream(file.inputStream())
            val note = out.readObject() as Note
            Log.i(TAG, id)
            listNotes[id.toInt()] = note
        }
    }
}

fun writeNote(note: Note, context: Context){
    val dir = File(context.filesDir, NOTE + note.id.toString() + EXT) // ex: "Note10.txt"
    val out = ObjectOutputStream(dir.outputStream())
    out.writeObject(note)
}

fun eraseNote(note: Note, context: Context){

}