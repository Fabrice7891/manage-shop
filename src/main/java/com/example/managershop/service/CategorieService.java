package com.example.managershop.service;

import com.example.managershop.entities.Categorie;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


public interface CategorieService {
    public Categorie findByIdcat(Long idcat);
    public Categorie addCategory(Categorie c);
    public boolean isExistCat(Long idCat);
    public void updateCat(Long idCat, Categorie newCat);
    public void deleteCat(Long idCat);
    public List<Categorie> findAll(String keyword);
    public Categorie searchCatById(Long id);

    public Optional<Categorie> searchCatById1(Long idcat);


}
