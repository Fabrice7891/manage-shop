package com.example.managershop.service;


import com.example.managershop.dto.FournisseurDto;
import com.example.managershop.entities.Fournisseur;
import com.example.managershop.exception.NullException;
import com.example.managershop.exception.RessourseNotFounfException;

import java.util.List;

public interface FournisseurService {

    public Fournisseur addfounisseur(FournisseurDto fournisseurDto) throws NullException;
    public List<Fournisseur> getAllFsseur();
    public Fournisseur getFsseurById(Long idfsseur) throws RessourseNotFounfException;
}
