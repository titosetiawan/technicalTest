package bts.exercise.controller;

import bts.exercise.model.Checklist;
import bts.exercise.model.Notes;
import bts.exercise.service.ChecklistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/checklists")
public class ChecklistController {

    @Autowired
    private ChecklistService checklistService;

    @GetMapping("/note/{noteId}")
    public List<Checklist> getChecklistByNoteId(@PathVariable Long noteId) {
        return checklistService.getChecklistByNoteId(noteId);
    }

    @PostMapping
    public Checklist createChecklist(@RequestBody String itemText, @RequestParam Long id) {
        // Membuat checklist baru dengan itemText dan noteId
        return checklistService.createChecklist(itemText, new Notes());
    }

    @PutMapping("/{id}")
    public Checklist updateChecklist(@PathVariable Long id, @RequestBody Checklist checklist) {
        return checklistService.updateChecklist(id, checklist);
    }

    @DeleteMapping("/{id}")
    public void deleteChecklist(@PathVariable Long id) {
        checklistService.deleteChecklist(id);
    }
}
