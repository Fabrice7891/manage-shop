package com.example.managershop.service.Impl;

import com.example.managershop.dao.FounisseurRepository;
import com.example.managershop.entities.Fournisseur;
import com.example.managershop.service.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class FournisseurServiceImpl implements FournisseurService {

    @Autowired
    private FounisseurRepository founisseurRepository;
    @Override
    public List<Fournisseur> getAllFournisseur() {
        return founisseurRepository.findAll();
    }

    @Override
    public Fournisseur findFsseurById(Long idfsseur) {
        if(!founisseurRepository.findById(idfsseur).isPresent())  throw new
        return null;
    }
}
