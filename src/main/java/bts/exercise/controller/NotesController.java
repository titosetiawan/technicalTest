package bts.exercise.controller;

import bts.exercise.model.Notes;
import bts.exercise.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/notes")
public class NotesController {

    @Autowired
    private NoteService noteService;

    @GetMapping
    public List<Notes> getAllNotes() {
        return noteService.getAllNotes();
    }

    @GetMapping("/{id}")
    public Optional<Notes> getNoteById(@PathVariable Long id) {
        return noteService.getNoteById(id);
    }

    @PostMapping
    public Notes createNote(@RequestBody Notes notes) {
        return noteService.createNote(notes);
    }

    @PutMapping("/{id}")
    public Notes updateNote(@PathVariable Long id, @RequestBody Notes notes) {
        return noteService.updateNote(id, notes);
    }

    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
    }
}
