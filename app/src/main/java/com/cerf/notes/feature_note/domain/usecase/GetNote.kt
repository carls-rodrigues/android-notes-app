package com.cerf.notes.feature_note.domain.usecase

import com.cerf.notes.feature_note.domain.model.Note
import com.cerf.notes.feature_note.domain.repository.NoteRepository

class GetNote (
    private val repository: NoteRepository
){
    suspend operator fun invoke(id: Int): Note? {
        return repository.getNoteById(id)
    }
}