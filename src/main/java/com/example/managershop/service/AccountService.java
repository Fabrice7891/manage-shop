package com.example.managershop.service;

import com.example.managershop.entities.Role;
import com.example.managershop.entities.User;

import java.util.List;


public interface AccountService {

    public User saveUser(String username, String password , String confirmedPassword);

    /**
     * @param role
     * @return
     */
    public Role save(Role role);


    public User loadUserByUsername( String username);
    public void addRoleToUser (String username , String rolename);
    public Role loadRoleByRolename(String roleName);
    public User addRoleToUser(Long idUser, Long idRole);

}
