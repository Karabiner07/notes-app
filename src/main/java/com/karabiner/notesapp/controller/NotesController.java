package com.karabiner.notesapp.controller;

import com.karabiner.notesapp.entity.Notes;
import com.karabiner.notesapp.entity.User;
import com.karabiner.notesapp.model.NotesDTO;
import com.karabiner.notesapp.service.NotesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class NotesController {

    @Autowired
    private NotesService notesService;

    @PostMapping("/notes")
    public Notes saveNotes(@Valid @RequestBody Notes notes){

        return notesService.saveNotes(notes);
    }

    @GetMapping("/api/userId/{userId}")
    public List<Notes> fetchAllNotesByUserId(@PathVariable("userId") Long userId){

        List<NotesDTO> notesDtoList = null;


        return notesService.findNotesByUser_UserId(userId);
    }






}
