package com.usgw.rathayatra.svc.dao;

import com.usgw.rathayatra.svc.model.Suggestion;

import java.util.List;

public interface SuggestionServiceDao {
    String addSuggestion(String message);

    List<Suggestion> getAllSuggestions();
}
