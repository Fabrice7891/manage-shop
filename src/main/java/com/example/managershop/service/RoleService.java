package com.example.managershop.service;


import com.example.managershop.entities.Role;

public interface RoleService {

    public Role updateRole(Long idRole, Role newRole );
    public String deleteRole(Role role);
    public Role loadRoleById(Long idRole);
}
