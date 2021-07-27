package com.example.managershop.service;


import com.example.managershop.entities.Fournisseur;

import java.util.List;

public interface FournisseurService {

    public List<Fournisseur> getAllFournisseur();
    public Fournisseur findFsseurById(Long Idfsseur);
}
