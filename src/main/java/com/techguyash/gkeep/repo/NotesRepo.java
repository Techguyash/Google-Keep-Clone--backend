package com.techguyash.gkeep.repo;

import com.techguyash.gkeep.entity.Notes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface NotesRepo extends JpaRepository<Notes,Long>
{

    @Query("select n from Notes n where n.trashed = true")
    List<Notes> findTrashedNotes();

    @Transactional
    @Modifying
    @Query("update Notes n set n.trashed = true where n.id = ?1")
    int updateTrashedTrue(long id);

    @Transactional
    @Modifying
    @Query("update Notes n set n.trashed = false where n.id = ?1")
    int updateTrashedFalse(long id);

    @Transactional
    @Modifying
    @Query("update Notes n set n.archived = true where n.id = ?1")
    int updateArchivedById(long id);

    @Transactional
    @Modifying
    @Query("update Notes n set n.archived = false where n.id = ?1")
    int updateNonArchivedById(long id);

    @Query("select n from Notes n where n.archived = true")
    List<Notes> findByArchivedTrue();

    @Query("select n from Notes n where n.trashed = false and n.archived = false")
    List<Notes> findByTrashedFalseAndArchivedFalse();


}
