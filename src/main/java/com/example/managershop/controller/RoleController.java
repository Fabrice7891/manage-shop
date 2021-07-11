package com.example.managershop.controller;

import com.example.managershop.entities.Role;
import com.example.managershop.service.AccountService;
import com.example.managershop.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/v1")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private AccountService accountService;

    @GetMapping("/listRoles")
    public Collection<Role> getAllRoles(){
        return roleService.listRoles();
    }

    @PostMapping("/addRole")
    public Role saveRole(@RequestBody Role role){
        return accountService.save(role);
    }


}
