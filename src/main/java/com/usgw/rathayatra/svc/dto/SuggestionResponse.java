package com.usgw.rathayatra.svc.dto;

import lombok.Data;

import java.util.Date;

@Data
public class SuggestionResponse {

    private String name;
    private String description;
    private Date date;
}
