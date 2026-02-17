package com.example.apiFirst.Controller;

import com.example.apiFirst.Entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    // Table
    private Map<Long, JournalEntry> journalEntries = new HashMap<>();

    @GetMapping
    public List<JournalEntry> getAll() { // localhost:8080/journal GET
    return new ArrayList<JournalEntry>(journalEntries.values());
}

    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry) { // localhost:8080/journal POST
        journalEntries.put(myEntry.getId(), myEntry);
        return true;
    }

    @GetMapping("/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable Long myId) {
        return journalEntries.get(myId);
    }

    @PutMapping("/{myId}")
    public JournalEntry updateJournalEntry(@RequestBody JournalEntry myEntry) {
        return journalEntries.put(myEntry.getId(), myEntry);
    }

    @DeleteMapping("/{myId}")
    public JournalEntry deleteJournalEntryById(@PathVariable Long myId) {
        return journalEntries.remove(myId);
    }

}
