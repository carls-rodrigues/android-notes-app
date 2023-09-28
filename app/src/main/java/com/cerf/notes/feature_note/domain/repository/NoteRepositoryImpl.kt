package com.cerf.notes.feature_note.domain.repository

import com.cerf.notes.feature_note.data.data_source.NoteDao
import com.cerf.notes.feature_note.domain.model.Note
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(
    private val dao: NoteDao
) : NoteRepository{
    override fun getNotes(): Flow<List<Note>> {
        return dao.getNotes()
    }

    override suspend fun getNoteById(id: Int): Note? {
        return dao.getNoteById(id)
    }

    override suspend fun insert(note: Note) {
        return dao.insert(note)
    }

    override suspend fun delete(note: Note) {
        return dao.delete(note)
    }
}