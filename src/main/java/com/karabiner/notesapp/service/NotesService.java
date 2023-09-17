package com.karabiner.notesapp.service;

import com.karabiner.notesapp.entity.Notes;
import com.karabiner.notesapp.model.NotesDTO;

import java.util.List;

public interface NotesService {
    public Notes saveNotes(Notes notes);
    public List<Notes> findNotesByUser_UserId(Long userId);
}
