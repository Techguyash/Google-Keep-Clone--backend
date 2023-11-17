package com.techguyash.gkeep.service;

import com.techguyash.gkeep.entity.Notes;
import com.techguyash.gkeep.repo.NotesRepo;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class NotesServiceImpl implements NotesService
{

    private final NotesRepo notesRepo;

    public List<Notes> getAllActiveNotesForUser()
    {
        List<Notes> all = notesRepo.findByTrashedFalseAndArchivedFalse();
        return all;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Notes getNote(Long id)
    {
     return notesRepo.findById(id).isPresent() ?
            notesRepo.findById(id).get():
            null;
    }

    @Override
    public boolean createNotesForUser(Notes notes)
    {
         notesRepo.save(notes);
         return Boolean.TRUE;
    }

    /**
     * @return
     */
    @Override
    public List<Notes> getAlltrashedNotes()
    {
        return notesRepo.findTrashedNotes();
    }

    /**
     * @param id
     * @return boolean
     */
    @Override
    public boolean trashNotes(Long id)
    {
        if(getNote(id)!=null)
        {
            notesRepo.updateTrashedTrue(id);
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * @param id
     * @return boolean
     */
    @Override
    public boolean deleteNotes(Long id)
    {
        if(getNote(id)!=null)
        {
            notesRepo.deleteById(id);
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Notes restoreNotes(Long id)
    {
        if(getNote(id)!=null)
        {
            notesRepo.updateTrashedFalse(id);
            return notesRepo.findById(id).get();
        }
         else
        {
            return null;
        }

    }

    /**
     * @param id
     * @return
     */
    @Override
    public boolean archiveNote(Long id)
    {
        if(getNote(id)!=null)
        {
            notesRepo.updateArchivedById(id);
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * @param id
     * @return
     */
    @Override
    public boolean unArchiveNote(Long id)
    {
        if(getNote(id)!=null)
        {
            notesRepo.updateNonArchivedById(id);
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * @return
     */
    @Override
    public List<Notes> getAllArchivedNotes()
    {
        return notesRepo.findByArchivedTrue();
    }
}
