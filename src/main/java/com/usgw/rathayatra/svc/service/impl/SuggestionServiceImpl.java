package com.usgw.rathayatra.svc.service.impl;

import com.usgw.rathayatra.svc.dao.impl.SuggestionServiceDaoImpl;
import com.usgw.rathayatra.svc.dto.SuggestionResponse;
import com.usgw.rathayatra.svc.service.SuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuggestionServiceImpl implements SuggestionService {

    @Autowired
    private SuggestionServiceDaoImpl suggestionServiceDao;

    @Override
    public String addSuggestion(String message) {
        return suggestionServiceDao.addSuggestion(message);
    }

    @Override
    public List<SuggestionResponse> getAllSuggestions() {
        return suggestionServiceDao.getAllSuggestions().stream().map(suggestion -> {
            SuggestionResponse suggestionResponse = new SuggestionResponse();
            suggestionResponse.setDescription(suggestion.getDescription());
            suggestionResponse.setName(suggestion.getName());
            suggestionResponse.setDate(suggestion.getCreatedAt());
            return suggestionResponse;
        }).toList();
    }
}
