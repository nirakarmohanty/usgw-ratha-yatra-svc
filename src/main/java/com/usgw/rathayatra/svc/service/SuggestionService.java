package com.usgw.rathayatra.svc.service;

import com.usgw.rathayatra.svc.dto.SuggestionResponse;
import com.usgw.rathayatra.svc.model.Suggestion;

import java.util.List;

public interface SuggestionService {
        String addSuggestion(String message);
        List<SuggestionResponse> getAllSuggestions();
}
