package com.cerf.notes.feature_note.domain.usecase

import com.cerf.notes.feature_note.domain.model.Note
import com.cerf.notes.feature_note.domain.repository.NoteRepository

class DeleteNote(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(note: Note) {
        repository.delete(note)
    }
}