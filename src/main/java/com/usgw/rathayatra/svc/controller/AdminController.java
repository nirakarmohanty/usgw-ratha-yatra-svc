package com.usgw.rathayatra.svc.controller;

import com.usgw.rathayatra.svc.dto.AdminRequest;
import com.usgw.rathayatra.svc.dto.AdminResponse;
import com.usgw.rathayatra.svc.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }


    @PostMapping("/create-admin")
    public ResponseEntity<AdminResponse> addAdmin(@RequestBody AdminRequest adminRequest) {
        if (adminRequest.getEmail() == null || adminRequest.getEmail().isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        AdminResponse adminResponse = adminService.addAdmin(adminRequest);
        //Convert Admin to AdminResponse

        return ResponseEntity.status(HttpStatus.CREATED).body(adminResponse);
    }

    @GetMapping("/is-admin")
    public ResponseEntity<Boolean> isAdmin(@RequestParam("email") String email) {
        if (email == null || email.isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        boolean isAdmin = adminService.isAdminByEmail(email);
        return ResponseEntity.ok(isAdmin);
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello(@RequestParam("message") String message) {

        String response = "Hello, you sent: " + message;
        return ResponseEntity.ok(response);
    }


    @DeleteMapping
    public ResponseEntity<Void> deleteAdmin(@RequestParam("email") String email) {
        if (email == null || email.isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        adminService.deleteAdminByEmail(email);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<AdminResponse>> listAdmins() {
        List<AdminResponse> adminResponses = adminService.listAdmins();
        // Convert List<Admin> to List<AdminResponse>
        return ResponseEntity.ok(adminResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdminResponse> getAdminById(@PathVariable String id) {
        Optional<AdminResponse> adminById = adminService.getAdminById(id);
        // Convert Admin to AdminResponse
        return adminById.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}

