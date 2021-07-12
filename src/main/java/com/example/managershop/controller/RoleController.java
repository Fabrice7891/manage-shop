package com.example.managershop.controller;

import com.example.managershop.entities.Categorie;
import com.example.managershop.entities.Role;
import com.example.managershop.service.AccountService;
import com.example.managershop.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("/api/v1")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private AccountService accountService;

    @GetMapping("/roles")
    public Collection<Role> getAllRoles(){
        return roleService.listRoles();
    }

    @PostMapping("/role")
    public Role saveRole(@Valid @RequestBody Role role){
        if(ObjectUtils.nullSafeEquals(role, null)) return  null;
        return accountService.save(role);
    }


    @GetMapping("/role")
    public ResponseEntity<Role> loadRoleByRolename(@RequestParam(value = "nameRole") String nameRole) {
        return new ResponseEntity<Role>(accountService.loadRoleByRolename(nameRole), HttpStatus.OK);
    }

}
