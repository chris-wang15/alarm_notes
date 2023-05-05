package com.tools.practicecompose.feature_note.domain.use_case

import com.tools.practicecompose.feature_note.domain.model.InvalidNoteException
import com.tools.practicecompose.feature_note.domain.model.Note
import com.tools.practicecompose.feature_note.domain.repository.NoteRepository

class AddNoteUseCase(
    private val repository: NoteRepository
) {
    @kotlin.jvm.Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank()) {
            throw InvalidNoteException("Title can not be empty")
        }
        if (note.content.isBlank()) {
            throw InvalidNoteException("Content can not be empty")
        }
        repository.insertNote(note)
    }
}