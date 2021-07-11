package com.example.managershop.service.Impl;

import com.example.managershop.dao.PersonneRepository;
import com.example.managershop.entities.Client;
import com.example.managershop.entities.User;
import com.example.managershop.service.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PersonneServiceImpl implements PersonneService {

    @Autowired
    private PersonneRepository personneRepository;
    @Override
    public void saveClient(Client c) {
        if(!loadClientByUsername(c.getLastNamePerson()).equals(null)) throw new RuntimeException("Client already exist !!");
        personneRepository.save(c);
    }

    @Override
    public void updateClient(String clientName, Client newClient) {
        Client client=(Client)personneRepository.findByNamePerson(clientName);
          if(client.equals(null)) throw new RuntimeException("Client not exist");
          client.setCivilitePerson(newClient.getCivilitePerson());
          client.setEmailPerson(newClient.getEmailPerson());
          client.setNamePerson(newClient.getNamePerson());
          client.setLastNamePerson(newClient.getLastNamePerson());
          client.setNumCniPerson(newClient.getNumCniPerson());
          client.setVillePerson(newClient.getVillePerson());
          client.setSoldeCredit(newClient.getSoldeCredit());
          client.setSoldeDebit(newClient.getSoldeDebit());
          client.setCommandes(newClient.getCommandes());
          personneRepository.save(client);
    }

    @Override
    public Client loadClientByUsername(String username) {
        return (Client) personneRepository.findByNamePerson(username);
    }

    @Override
    public void deleteCleint(Client c) {
          if(loadClientByUsername(c.getLastNamePerson()).equals(null)) throw new RuntimeException("Client not found");
          personneRepository.delete(c);
    }

    @Override
    public void updateUser(Long idUser, User newUser) {
        User user= loadUserByid(idUser);
        if(user.equals(null)) throw new RuntimeException("user not exist");
        user.setCivilitePerson(newUser.getCivilitePerson());
        user.setEmailPerson(newUser.getEmailPerson());
        user.setNamePerson(newUser.getNamePerson());
        user.setLastNamePerson(newUser.getLastNamePerson());
        user.setNumCniPerson(newUser.getNumCniPerson());
        user.setVillePerson(newUser.getVillePerson());
        if(newUser.getPassword().equals(newUser.getPasswordConfirmed())) throw new RuntimeException("Please Confirme your passWord");
        user.setPassword(newUser.getPassword());
        user.setPhoto(newUser.getPhoto());
        personneRepository.save(user);
    }

    @Override
    public void deleteUser(Long idUser) {
        if(loadUserByid(idUser).equals(null)) throw new RuntimeException("User not found");
        personneRepository.delete(loadUserByid(idUser));
    }

    @Override
    public User loadUserByid(Long idUser) {
        return (User)personneRepository.findById(idUser).get();
    }
}
