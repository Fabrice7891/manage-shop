package com.example.managershop.service;

import com.example.managershop.entities.Categorie;
import com.example.managershop.exception.CategorieNotFoundException;

import java.util.List;


public interface CategorieService {
    public Categorie findByIdcat(Long idcat);
    public Categorie addCategory(Categorie c);
    public boolean isExistCat(Long idCat);
    public void updateCat(Long idCat, Categorie newCat) throws CategorieNotFoundException;
    public void deleteCat(Long idCat);
    public Categorie deleteCat(Categorie cat);
    public List<Categorie> findAll(String keyword);
    public List<Categorie> findAll();
    public Categorie searchCatById(Long id);

    public Categorie searchCatById1(Long idcat);


}
