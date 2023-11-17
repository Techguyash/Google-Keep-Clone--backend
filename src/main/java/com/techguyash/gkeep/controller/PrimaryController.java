package com.techguyash.gkeep.controller;

import com.techguyash.gkeep.entity.Notes;
import com.techguyash.gkeep.service.NotesService;
import lombok.Data;
import org.aspectj.weaver.ast.Not;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController("/")
public class PrimaryController
{
    private final NotesService notesService;

    @GetMapping
    public List<Notes> getAllActiveNotesForUser()
    {
        return notesService.getAllActiveNotesForUser();
    }

    @PostMapping
    public ResponseEntity<Boolean> createNewNote(@RequestBody Notes notes)
    {
        notesService.createNotesForUser(notes);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("trash")
    public List<Notes> getTrashNotes()
    {
        return notesService.getAlltrashedNotes();
    }

    @DeleteMapping("trash/{id}")
    public ResponseEntity trashNotes(@PathVariable Long id)
    {
       notesService.trashNotes(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/trash/restore/{id}")
    public ResponseEntity<Notes> restoreTrashedNote(@PathVariable long id)
    {
        Notes notes = notesService.restoreNotes(id);
        return new ResponseEntity<>(notes,HttpStatus.OK);

    }

    @DeleteMapping("/trash/forever/{id}")
    public ResponseEntity deleteUserNotes(@PathVariable Long id)
    {
        notesService.deleteNotes(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/archive")
    public List<Notes> getAllArchivedNotesForUser()
    {
        return notesService.getAllArchivedNotes();
    }


    @PutMapping("/archive/{id}")
    public ResponseEntity archiveUserNote(@PathVariable long id)
    {
        notesService.archiveNote(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
    @PutMapping("/unarchive/{id}")
    public ResponseEntity unArchiveUserNote(@PathVariable long id)
    {
        notesService.unArchiveNote(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
