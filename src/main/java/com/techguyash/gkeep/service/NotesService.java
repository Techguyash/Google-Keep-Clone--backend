package com.techguyash.gkeep.service;

import com.techguyash.gkeep.entity.Notes;

import java.util.List;

public interface NotesService
{
    List<Notes> getAllActiveNotesForUser();

    Notes getNote(Long id);

    boolean createNotesForUser(Notes notes);

    List<Notes> getAlltrashedNotes();

    boolean trashNotes(Long id);

    boolean deleteNotes(Long id);
    Notes restoreNotes(Long id);

    boolean archiveNote(Long id);
    boolean unArchiveNote(Long id);

    List<Notes> getAllArchivedNotes();
}
