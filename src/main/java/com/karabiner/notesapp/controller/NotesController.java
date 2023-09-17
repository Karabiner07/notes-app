package com.karabiner.notesapp.controller;

import com.karabiner.notesapp.entity.Notes;
import com.karabiner.notesapp.service.AutoDel;
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

    @Autowired
    private AutoDel autoDel;

    @PostMapping("/notes")
    public Notes saveNotes(@Valid @RequestBody Notes notes){

        return notesService.saveNotes(notes);
    }

    @GetMapping("/api/userId/{userId}")
    public List<Notes> fetchAllNotesByUserId(@PathVariable("userId") Long userId){
        return notesService.findNotesByUser_UserId(userId);
    }

    @PostMapping("/api/del")
    public void deleteRecordsOlderThanTen(){
        autoDel.autoDelNotesOlderThanTen();
    }
}
