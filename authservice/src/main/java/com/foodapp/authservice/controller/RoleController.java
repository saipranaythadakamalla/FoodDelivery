package com.foodapp.authservice.controller;

import com.foodapp.authservice.model.Role;
import com.foodapp.authservice.service.RoleService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    // ✅ Create Role
    @PostMapping("/create")
    public ResponseEntity<Role> createRole(
            @RequestParam String roleName) {

        Role role = roleService.createRole(roleName);

        return ResponseEntity.ok(role);
    }
}
