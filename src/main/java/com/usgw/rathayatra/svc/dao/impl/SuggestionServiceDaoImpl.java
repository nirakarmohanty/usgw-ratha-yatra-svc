package com.usgw.rathayatra.svc.dao.impl;

import com.usgw.rathayatra.svc.dao.SuggestionServiceDao;
import com.usgw.rathayatra.svc.model.Suggestion;
import com.usgw.rathayatra.svc.repository.SuggestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class SuggestionServiceDaoImpl implements SuggestionServiceDao {
    @Autowired
    private SuggestionRepository suggestionRepository;

    @Override
    public String addSuggestion(String message) {

        Suggestion suggestion = new Suggestion();
        suggestion.setDescription(message);
        suggestion.setName("Test NAme");
        suggestion.setCreatedAt(new Date());
        return suggestionRepository.save(suggestion).toString();
    }

    @Override
    public List<Suggestion> getAllSuggestions() {
        List<Suggestion> all = suggestionRepository.findAll();
        return all;
    }
}
