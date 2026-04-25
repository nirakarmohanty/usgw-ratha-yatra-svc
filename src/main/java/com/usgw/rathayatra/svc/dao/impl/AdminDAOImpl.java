package com.usgw.rathayatra.svc.dao.impl;

import com.usgw.rathayatra.svc.dao.AdminDAO;
import com.usgw.rathayatra.svc.dao.AdminRepository;
import com.usgw.rathayatra.svc.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AdminDAOImpl implements AdminDAO {

    private final AdminRepository adminRepository;

    @Autowired
    public AdminDAOImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public Admin save(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public Optional<Admin> findByEmail(String email) {
        return adminRepository.findByEmail(email);
    }

    @Override
    public Optional<Admin> findById(String id) {
        return adminRepository.findById(id);
    }

    @Override
    public boolean existsByEmail(String email) {
        return adminRepository.findByEmail(email).isPresent();
    }

    @Override
    public void deleteByEmail(String email) {
        adminRepository.findByEmail(email).ifPresent(admin -> adminRepository.delete(admin));
    }

    @Override
    public List<Admin> findAll() {
        return adminRepository.findAll();
    }
}

