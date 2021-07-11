package com.example.managershop.service;

import com.example.managershop.entities.Categorie;
import com.example.managershop.entities.Produit;
import com.example.managershop.exception.CategorieNotFoundException;

import java.util.List;


public interface CategorieService {
    public Categorie findByIdcat(Long idcat);
    public Categorie addCategory(Categorie c);
    public boolean isExistCat(Long idCat);
    public Categorie updateCat(Long idCat, Categorie newCat) throws CategorieNotFoundException;
    public Categorie deleteCat(Long idCat);
    public List<Categorie> findAll(String keyword);
    public List<Categorie> findAll();
    public Categorie searchCatById(Long id);
    public Categorie searchCatById1(Long idcat);
    public Categorie addProductToCategorie(Long idPdt, Long idCat);
    public Categorie deleteProductToCategorie(Long idPdt , Long idCat);
    public Categorie deleteProductToCategorie(List<Produit> produits , Long idCat);



}
