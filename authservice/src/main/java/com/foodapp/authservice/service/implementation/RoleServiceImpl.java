package com.foodapp.authservice.service.implementation;

import com.foodapp.authservice.model.Role;
import com.foodapp.authservice.repository.RoleRepository;
import com.foodapp.authservice.service.RoleService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class RoleServiceImpl implements RoleService {
  
  private final RoleRepository roleRepository;

    @Override
    public Role createRole(String roleName) {

        if (roleRepository.findByName(roleName).isPresent()) {
            throw new RuntimeException("Role already exists");
        }

        Role role = Role.builder()
                .name(roleName)
                .build();

        return roleRepository.save(role);
    }

    @Override
    public Role getRoleByName(String roleName) {

        return roleRepository.findByName(roleName)
                .orElseThrow(() -> new RuntimeException("Role not found"));
    }
}
