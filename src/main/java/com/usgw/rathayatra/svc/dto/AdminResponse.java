package com.usgw.rathayatra.svc.dto;

import lombok.Data;

import java.time.Instant;
import java.util.Date;

@Data
public class AdminResponse {
    private String id;
    private String name;
    private String email;
    private Date createdAt;

    public AdminResponse() {
    }

    public AdminResponse(String id, String name, String email, Date createdAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.createdAt = createdAt;
    }

}

