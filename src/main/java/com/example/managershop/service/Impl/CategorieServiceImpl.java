package com.example.managershop.service.Impl;

import com.example.managershop.dao.CategoryRepository;
import com.example.managershop.entities.Categorie;
import com.example.managershop.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategorieServiceImpl implements CategorieService {

    @Autowired
    private CategorieService categorieService ;

    @Autowired
    private CategoryRepository categoryRepository ;


    @Override
    public Categorie findByIdcat(Long idcat) {
        return categoryRepository.findByIdCat(idcat);
    }

    @Override
    public Categorie addCategory(Categorie c) {

        return categoryRepository.save(c);
    }

    @Override
    public boolean isExistCat(Long idCat) {
        return categoryRepository.existsById(idCat);
    }

    @Override
    public void updateCat(Long idCat, Categorie newCat) {
        if(!isExistCat(idCat)) throw new RuntimeException("Categorie not exist");

            Categorie cat= categoryRepository.findByIdCat(idCat);
            cat.setNomCat(newCat.getNomCat());
            cat.setArchived(newCat.isArchived());
            categoryRepository.save(cat);
    }

    @Override
    public void deleteCat(Long idCat) {
        if(!isExistCat(idCat)) throw new RuntimeException("Categorie introuvable");
        categoryRepository.deleteById(idCat);

    }

    @Override
    public List<Categorie> findAll(String keyword) {
        if(keyword!=null){
            return categoryRepository.findAll(keyword);
        }
        return categoryRepository.findAll();
    }


    @Override
    public Categorie searchCatById(Long id) {
        return categoryRepository.findByIdCat(id);
    }

    @Override
    public Optional<Categorie> searchCatById1(Long id) {
        return categoryRepository.findById(id);  // Comment gerer le Optional?
    }


}
