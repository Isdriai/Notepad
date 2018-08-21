package com.appli.picot.notepad

fun readNotes(listNotes: kotlin.collections.ArrayList<Note>){
    listNotes.add(Note("titre", "voici du texte"))
    listNotes.add(Note("titre1", "voici du texte"))
    listNotes.add(Note("titre2", "voici du texte"))
    listNotes.add(Note("titre3", "voici du texte"))
    listNotes.add(Note("titre4", "voici du texte"))
    listNotes.add(Note("titre5", "voici du texte"))
    listNotes.add(Note("titre6", "voici du texte"))
    listNotes.add(Note("titre7", "voici du texte"))
    listNotes.add(Note("titre8", "voici du texte"))
    listNotes.add(Note("titre9", "voici du texte"))
    listNotes.add(Note("titre10", "voici du texte"))
}

fun writeNote(note: Note){
    print("J'écris la note dont le titre est ${note.titre} \n")
}