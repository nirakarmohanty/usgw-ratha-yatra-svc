package com.usgw.rathayatra.svc.dao;

import com.usgw.rathayatra.svc.model.Suggestion;
import java.util.List;

public interface SuggestionDao {
    List<Suggestion> findAll();
}

