package com.example.managershop.service.Impl;

import com.example.managershop.dao.CategoryRepository;
import com.example.managershop.entities.Categorie;
import com.example.managershop.exception.CategorieNotFoundException;
import com.example.managershop.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

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
        /*Categorie categorie= findByIdcat(c.getIdCat());
        if(!categorie.equals(null)) throw new RuntimeException("Category already exist");*/
        return categoryRepository.save(c);
    }

    @Override
    public boolean isExistCat(Long idCat) {
        return categoryRepository.existsById(idCat);
    }

    @Override
    public void updateCat(Long idCat, Categorie newCat) throws CategorieNotFoundException {
        if(ObjectUtils.nullSafeEquals(newCat,null)) return;
        if(!isExistCat(idCat)) throw new CategorieNotFoundException("Categorie Not Found");
            Categorie cat= categoryRepository.findByIdCat(idCat);
            if(ObjectUtils.isEmpty(cat)) throw new CategorieNotFoundException("Categorie Not Found");
            cat.setNomCat(newCat.getNomCat());
            cat.setArchived(newCat.getArchived());
            categoryRepository.save(cat);

    }

    @Override
    public void deleteCat(Long idCat) {
        if(ObjectUtils.nullSafeEquals(searchCatById1(idCat),null)) return ;
        categoryRepository.delete(searchCatById1(idCat));
        /*return cat;
        if(!isExistCat(idCat)) throw new RuntimeException("Categorie introuvable");
        categoryRepository.deleteById(idCat);*/

    }

    @Override
    public Categorie deleteCat(Categorie cat) {
        if(ObjectUtils.nullSafeEquals(cat, null)) { return null;}
        if(ObjectUtils.nullSafeEquals(searchCatById1(cat.getIdCat()),null)) throw new RuntimeException("Category not exist");
        categoryRepository.delete(cat);
        return cat;
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
    
}
