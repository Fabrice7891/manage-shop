package com.example.managershop.service;



import com.example.managershop.entities.Fournisseur;

import java.util.List;

public interface FournisseurService {

    public List<Fournisseur> getAllFournisseur();
    public Fournisseur findFsseurById(Long Idfsseur);
=======
import com.example.managershop.dto.FournisseurDto;
import com.example.managershop.entities.Fournisseur;
import com.example.managershop.exception.NullException;

public interface FournisseurService {

    public Fournisseur addfounisseur(FournisseurDto fournisseurDto) throws NullException;

}
