package com.cerf.notes.di

import android.app.Application
import androidx.room.Room
import com.cerf.notes.feature_note.data.data_source.NoteDao
import com.cerf.notes.feature_note.data.data_source.NoteDatabase
import com.cerf.notes.feature_note.domain.repository.NoteRepository
import com.cerf.notes.feature_note.domain.repository.NoteRepositoryImpl
import com.cerf.notes.feature_note.domain.usecase.AddNote
import com.cerf.notes.feature_note.domain.usecase.DeleteNote
import com.cerf.notes.feature_note.domain.usecase.GetNote
import com.cerf.notes.feature_note.domain.usecase.GetNotes
import com.cerf.notes.feature_note.domain.usecase.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNodeRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getNotes = GetNotes(repository),
            deleteNote = DeleteNote(repository),
            addNote = AddNote(repository),
            getNote = GetNote(repository)
        )

    }
}