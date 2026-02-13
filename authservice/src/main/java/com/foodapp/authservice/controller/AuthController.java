package com.foodapp.authservice.controller;

import com.foodapp.authservice.model.User;
import com.foodapp.authservice.service.UserService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.foodapp.authservice.dto.RegisterRequest;
import com.foodapp.authservice.dto.AssignRoleRequest;
import com.foodapp.authservice.dto.UserResponse;


import java.util.UUID;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(
            @RequestBody RegisterRequest request) {

        User user = userService.registerUser(
                request.getUsername(),
                request.getEmail(),
                request.getPassword()
        );

        return ResponseEntity.ok(convertToResponse(user));
    }

    @PostMapping("/assign-role")
    public ResponseEntity<UserResponse> assignRole(
            @RequestBody AssignRoleRequest request) {

        User user = userService.assignRoleToUser(
                request.getUserId(),
                request.getRoleName()
        );

        return ResponseEntity.ok(convertToResponse(user));
    }

    private UserResponse convertToResponse(User user) {

        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .roles(user.getRoles()
                        .stream()
                        .map(role -> role.getName())
                        .collect(java.util.stream.Collectors.toSet()))
                .build();
    }
}
