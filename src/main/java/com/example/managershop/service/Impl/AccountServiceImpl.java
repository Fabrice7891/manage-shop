package com.example.managershop.service.Impl;

import com.example.managershop.dao.PersonneRepository;
import com.example.managershop.dao.RoleRepository;
import com.example.managershop.entities.Personne;
import com.example.managershop.entities.Role;
import com.example.managershop.entities.User;
import com.example.managershop.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.management.relation.RoleNotFoundException;


@Service
@Transactional
public class AccountServiceImpl implements AccountService
{


    @Autowired
    private PersonneRepository personneRepository ;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User saveUser(String username, String password, String confirmedPassword) {

        User user=(User)personneRepository.findByNamePerson(username);
        if(((User)personneRepository.findByNamePerson(username)).equals(null)) throw new RuntimeException("User already exist");
        if(!password.equals(confirmedPassword)) throw new  RuntimeException("Please confirm your password");
        User user1 = User.builder().build();
               // new User();
        user1.setNamePerson(username);
        user1.setActivated(true);
        user1.setPassword(bCryptPasswordEncoder.encode(password));
        personneRepository.save(user1);
        addRoleToUser(username, "USER");
        return user1;
    }

    @Override
    public Role save(Role role) throws RuntimeException{

        if(!roleRepository.findByNameRole(role.getNameRole()).equals(null)) throw new RuntimeException("Role already exist");
        return roleRepository.save(role);
    }

    @Override
    public User loadUserByUsername(String username) {
        return (User)personneRepository.findByNamePerson(username);
    }

    @Override
    public void addRoleToUser(String username, String rolename) throws UsernameNotFoundException,RuntimeException {

        if(loadUserByUsername(username).equals(null)) throw  new UsernameNotFoundException("Use not exist");
        if(loadUserByRolename(rolename).equals(null)) throw new RuntimeException("Role not exist");
        loadUserByUsername(username).getRoles().add(loadUserByRolename(rolename));

    }

    @Override
    public Role loadUserByRolename(String roleName) {
        return roleRepository.findByNameRole(roleName);
    }

}
