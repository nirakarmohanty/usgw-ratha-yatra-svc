package com.usgw.rathayatra.svc.repository;

import com.usgw.rathayatra.svc.model.Suggestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuggestionRepository extends JpaRepository<Suggestion, Long> {

}
