package com.karabiner.notesapp.service;

import com.karabiner.notesapp.entity.Notes;
import com.karabiner.notesapp.entity.User;
import com.karabiner.notesapp.repository.NotesRepository;
import com.karabiner.notesapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoDel {

    @Autowired
    private UserRepository userRepository;



    @Autowired
    private NotesRepository notesRepository;

    @Scheduled(fixedRate = 1 * 60 * 60 * 1000)
    public void autoDelNotesOlderThanTen(){

        List<User> userList = userRepository.findAll();

        for(User eachUser : userList ){
            List<Notes> userNotes = notesRepository.findNotesByUser_UserId(eachUser.getUserId());

            if(userNotes.size() > 10) {
                Notes oldestNote = userNotes.get(0);
                notesRepository.deleteById(oldestNote.getNotesId());
            }
        }
    }

}
