package com.foodapp.authservice.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class AssignRoleRequest {

    private UUID userId;
    private String roleName;
}
