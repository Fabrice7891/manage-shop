package com.example.managershop.service.Impl;

import com.example.managershop.dao.CategoryRepository;
import com.example.managershop.entities.Categorie;
import com.example.managershop.entities.Produit;
import com.example.managershop.exception.CategorieNotFoundException;
import com.example.managershop.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategorieServiceImpl implements CategorieService {

    @Autowired
    private CategorieService categorieService ;

    @Autowired
    private CategoryRepository categoryRepository ;


    @Override
    public Categorie findByIdcat(Long idcat) {
        if(ObjectUtils.nullSafeEquals(categoryRepository.findByIdCat(idcat),null)) return null;
        return categoryRepository.findById(idcat).get();
    }

    @Override
    public Categorie addCategory(Categorie c) {
        if(ObjectUtils.nullSafeEquals(c, null)) {return null;}
        return categoryRepository.save(c);
    }

    @Override
    public boolean isExistCat(Long idCat) {
        return categoryRepository.existsById(idCat);
    }

    @Override
    public Categorie updateCat(Long idCat, Categorie newCat) {
        if(ObjectUtils.nullSafeEquals(findByIdcat(idCat),null)) return null;
        if(ObjectUtils.nullSafeEquals(newCat,null)){
            return categoryRepository.findById(idCat).get();
        }
        findByIdcat(idCat).setNomCat(newCat.getNomCat());
        findByIdcat(idCat).setArchived(newCat.getArchived());
        return categoryRepository.save(findByIdcat(idCat));

    }

    @Override
    public Categorie deleteCat(Long idCat){
        if(!categoryRepository.findById(idCat).isPresent()) return null;
        Categorie cate = categoryRepository.findById(idCat).get();
        categoryRepository.delete(findByIdcat(idCat));
        return cate;
    }


    @Override
    public List<Categorie> findAll(String keyword) {
        if(keyword!=""){
            return categoryRepository.findAll(keyword);
        }
        return categoryRepository.findAll();
    }

    @Override
    public List<Categorie> findAll() {
        return categoryRepository.findAll();
    }


    @Override
    public Categorie searchCatById(Long id) {
        return categoryRepository.findByIdCat(id);
    }

    @Override
    public Categorie searchCatById1(Long id) {
        if(categoryRepository.findById(id).isPresent())
           return categoryRepository.findById(id).get();
        else return null;
    }

    @Override
    public Categorie addProductToCategorie(Long idPdt, Long idCat) {
        return null;
    }

    @Override
    public Categorie deleteProductToCategorie(Long idPdt, Long idCat) {
        return null;
    }

    @Override
    public Categorie deleteProductToCategorie(List<Produit> produits, Long idCat) {
        return null;
    }

}
