package com.example.managershop.service;

import com.example.managershop.entities.Personne;
import com.example.managershop.entities.Role;
import com.example.managershop.entities.User;


public interface AccountService {

    public User saveUser(String username, String password , String confirmedPassword);

    /**
     * @param role
     * @return
     */
    public Role save(Role role);
    public User loadUserByUsername( String username);
    public void addRoleToUser (String username , String rolename);
}
