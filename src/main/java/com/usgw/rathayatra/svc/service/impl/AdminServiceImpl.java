package com.usgw.rathayatra.svc.service.impl;

import com.usgw.rathayatra.svc.dao.AdminDAO;
import com.usgw.rathayatra.svc.dto.AdminRequest;
import com.usgw.rathayatra.svc.dto.AdminResponse;
import com.usgw.rathayatra.svc.model.Admin;
import com.usgw.rathayatra.svc.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    private final AdminDAO adminDAO;

    @Autowired
    public AdminServiceImpl(AdminDAO adminDAO) {
        this.adminDAO = adminDAO;
    }

    @Override
    public AdminResponse addAdmin(AdminRequest admin) {
        // If admin with email already exists, return existing one or throw. We'll return existing for idempotency.
        Optional<Admin> existing = adminDAO.findByEmail(admin.getEmail());
        if (existing.isPresent()) {
            Admin admin1 = existing.get();
            AdminResponse response = new AdminResponse();
            response.setId(admin1.getId());
            response.setName(admin1.getName());
            response.setEmail(admin1.getEmail());
            response.setCreatedAt(admin1.getCreatedAt());
            return response;
        }

        //Convert AdminRequest to Admin entity
        Admin newAdmin = new Admin(admin.getName(), admin.getEmail());
        Admin created = adminDAO.save(newAdmin);

        //Convert saved Admin to AdminResponse if needed. Here we return the entity directly.
        AdminResponse response = new AdminResponse();
        response.setId(created.getId());
        response.setName(created.getName());
        response.setEmail(created.getEmail());
        response.setCreatedAt(created.getCreatedAt());
        return response;
    }

    @Override
    public boolean isAdminByEmail(String email) {
        return adminDAO.existsByEmail(email);
    }

    @Override
    public void deleteAdminByEmail(String email) {
        adminDAO.deleteByEmail(email);
    }

    @Override
    public List<AdminResponse> listAdmins() {
        List<Admin> all = adminDAO.findAll();
        // Convert List<Admin> to List<AdminResponse>
        return all.stream().map(admin -> {
            AdminResponse response = new AdminResponse();
            response.setId(admin.getId());
            response.setName(admin.getName());
            response.setEmail(admin.getEmail());
            return response;
        }).toList();
    }

    @Override
    public Optional<AdminResponse> getAdminById(String id) {
        Optional<Admin> byId = adminDAO.findById(id);
        // Convert Optional<Admin> to Optional<AdminResponse>
        return byId.map(admin -> {
            AdminResponse response = new AdminResponse();
            response.setId(admin.getId());
            response.setName(admin.getName());
            response.setEmail(admin.getEmail());
            return response;
        });
    }

    @Override
    public Optional<AdminResponse> getAdminByEmail(String email) {
        Optional<Admin> byEmail = adminDAO.findByEmail(email);
        // Convert Optional<Admin> to Optional<AdminResponse>
        return byEmail.map(admin -> {
            AdminResponse response = new AdminResponse();
            response.setId(admin.getId());
            response.setName(admin.getName());
            response.setEmail(admin.getEmail());
            return response;
        });
    }
}

