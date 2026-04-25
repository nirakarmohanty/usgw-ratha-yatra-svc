package com.usgw.rathayatra.svc.dao;

import com.usgw.rathayatra.svc.model.Admin;

import java.util.List;
import java.util.Optional;

public interface AdminDAO {
    Admin save(Admin admin);
    Optional<Admin> findByEmail(String email);
    Optional<Admin> findById(String id);
    boolean existsByEmail(String email);
    void deleteByEmail(String email);
    List<Admin> findAll();
}

