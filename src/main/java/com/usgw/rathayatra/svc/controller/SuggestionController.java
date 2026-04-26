package com.usgw.rathayatra.svc.controller;

import com.usgw.rathayatra.svc.dto.SuggestionResponse;
import com.usgw.rathayatra.svc.model.Suggestion;
import com.usgw.rathayatra.svc.service.SuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/suggestions")
public class SuggestionController {

    private final SuggestionService suggestionService;

    @Autowired
    public SuggestionController(SuggestionService suggestionService) {
        this.suggestionService = suggestionService;
    }

    @PostMapping("/addSuggestion")
    public ResponseEntity<String> addSuggestion(@RequestParam("message") String message) {
        String s = suggestionService.addSuggestion(message);
        return ResponseEntity.ok(s);
    }

    @GetMapping("/getAllSuggestions")
    public ResponseEntity<List<SuggestionResponse>> getAllSuggestions() {
        List<SuggestionResponse> allSuggestions = suggestionService.getAllSuggestions();
        return ResponseEntity.ok(allSuggestions);
    }
}
