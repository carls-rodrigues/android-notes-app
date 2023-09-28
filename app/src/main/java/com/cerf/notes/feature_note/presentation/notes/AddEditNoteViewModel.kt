package com.cerf.notes.feature_note.presentation.notes

import androidx.lifecycle.ViewModel
import com.cerf.notes.feature_note.domain.usecase.NoteUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddEditNoteViewModel @Inject constructor(
    private val noteUseCases: NoteUseCases
): ViewModel() {

}