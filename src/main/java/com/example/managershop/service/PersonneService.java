package com.example.managershop.service;


import com.example.managershop.entities.Client;
import com.example.managershop.entities.User;

public interface PersonneService {

    public void saveClient(Client c);
    public void updateClient(String clientName , Client newClient);
    public Client loadClientByUsername(String username);
    public void deleteCleint(Client c);
    public void updateUser(Long idUser , User newUser);
    public void deleteUser(Long idUser);
    public User loadUserByid(Long idUser);
}
