package com.usgw.rathayatra.svc.service;

import com.usgw.rathayatra.svc.dto.AdminRequest;
import com.usgw.rathayatra.svc.dto.AdminResponse;
import com.usgw.rathayatra.svc.model.Admin;

import java.util.List;
import java.util.Optional;

public interface AdminService {
    AdminResponse addAdmin(AdminRequest admin);
    boolean isAdminByEmail(String email);
    void deleteAdminByEmail(String email);
    List<AdminResponse> listAdmins();
    Optional<AdminResponse> getAdminById(String id);
    Optional<AdminResponse> getAdminByEmail(String email);
}

