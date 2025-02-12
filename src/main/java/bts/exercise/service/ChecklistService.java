package bts.exercise.service;

import bts.exercise.model.Checklist;
import bts.exercise.model.Notes;
import bts.exercise.repository.ChecklistRepository;
import bts.exercise.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChecklistService {

    @Autowired
    private ChecklistRepository checklistRepository;
    @Autowired
    private NoteRepository noteRepository;

    public List<Checklist> getChecklistByNoteId(Long noteId) {
        return checklistRepository.findByNoteId(noteId);
    } 

    public Checklist createChecklist(String itemText, Notes id) {

        Notes note = noteRepository.findById(id.getId())
                .orElseThrow(() -> new RuntimeException("Note not found"));

        Checklist checklist = new Checklist();
        checklist.setItemText(itemText);
        checklist.setNote(note);
        return checklistRepository.save(checklist);
    }

    public Checklist updateChecklist(Long id, Checklist checklist) {
        checklist.setId(id);
        return checklistRepository.save(checklist);
    }

    public void deleteChecklist(Long id) {
        checklistRepository.deleteById(id);
    }
}
