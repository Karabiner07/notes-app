package com.karabiner.notesapp.repository;

import com.karabiner.notesapp.entity.Notes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Repository
public interface NotesRepository extends JpaRepository<Notes, Long> {

    public List<Notes> findNotesByUser_UserId(Long userId);

}
