package com.example.managershop.service.Impl;

import com.example.managershop.dao.PersonneRepository;
import com.example.managershop.dao.RoleRepository;
import com.example.managershop.entities.Role;
import com.example.managershop.entities.User;
import com.example.managershop.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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
        return null;
    }

    @Override
    public Role save(Role role) {
        return null;
    }

    @Override
    public User loadUserByUsername(String username) {
        return null;
    }

    @Override
    public void addRoleToUser(String username, String rolename) {

    }

   /*



    */

    /*@Override
    public User saveUser(String username, String password, String confirmedPassword) {
        Personne user= personneRepository.findByNamePerson(username);
        if(user!=null) throw  new RuntimeException("User already exist");
        if(!password.equals(confirmedPassword)) throw new  RuntimeException("Please confirm your password");
        User user1 =new User();
        user1.setNamePerson(username);
        user1.setActivated(true);
        user1.setPassword(bCryptPasswordEncoder.encode(password));
        personneRepository.save(user1);
        addRoleToUser(username, "USER");
        return (Personne)User;
    }

    @Override
    public Role save(Role role) {
        return null;
    }

    @Override
    public AppRole save(AppRole role) {
        return appRoleRepository.save(role);
    }

    @Override
    public User loadUserByUsername(String username) {

        return (User)personneRepository.findByNamePerson(username);
    }

    @Override
    public void addRoleToUser(String username, String rolename) {
       User user=(User)personneRepository.findByNamePerson(username);
       Role role=roleRepository.findByNameRole(rolename);
       user.getRoles().add(role);
    }*/
}
