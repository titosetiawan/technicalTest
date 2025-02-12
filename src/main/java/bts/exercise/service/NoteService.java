package bts.exercise.service;

import bts.exercise.model.Notes;
import bts.exercise.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public List<Notes> getAllNotes() {
        return noteRepository.findAll();
    }

    public Optional<Notes> getNoteById(Long id) {
        return noteRepository.findById(id);
    }

    public Notes createNote(Notes notes) {
        notes.setCreatedAt(java.time.LocalDateTime.now());
        notes.setUpdatedAt(notes.getCreatedAt());
        return noteRepository.save(notes);
    }

    public Notes updateNote(Long id, Notes notes) {
        notes.setId(id);
        notes.setUpdatedAt(java.time.LocalDateTime.now());
        return noteRepository.save(notes);
    }

    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }
}
