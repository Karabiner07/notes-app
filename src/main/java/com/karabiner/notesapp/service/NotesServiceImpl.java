package com.karabiner.notesapp.service;

import com.karabiner.notesapp.entity.Notes;
import com.karabiner.notesapp.model.NotesDTO;
import com.karabiner.notesapp.repository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotesServiceImpl implements NotesService{

    @Autowired
    private NotesRepository notesRepository;

    @Override
    public Notes saveNotes(Notes notes) {
        return notesRepository.save(notes);
    }

    @Override
    public List<Notes> findNotesByUser_UserId(Long userId) {


        return notesRepository.findNotesByUser_UserId(userId);
    }
}
