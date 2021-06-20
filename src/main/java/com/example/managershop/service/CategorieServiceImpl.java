package com.example.managershop.service;

import com.example.managershop.entities.Categorie;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
@Transactional
public class CategorieServiceImpl implements CategorieService{
    @Override
    public void addCategory(Categorie c) {

    }

    @Override
    public boolean isExistCat(Long idCat) {
        return false;
    }

    @Override
    public void updateCat(Long idCat, Categorie newCat) {

    }

    @Override
    public void deleteCat(Long idCat) {

    }

    @Override
    public Collection<Categorie> showAllCat() {
        return null;
    }

    @Override
    public Categorie searchCatById(Long id) {
        return null;
    }

    @Override
    public Collection<Categorie> searchByKeyWord(String keyWord) {
        return null;
    }
}
