package com.example.managershop.service.Impl;

import com.example.managershop.dao.CategoryRepository;
import com.example.managershop.entities.Categorie;
import com.example.managershop.entities.Produit;
import com.example.managershop.exception.CategorieNotFoundException;
import com.example.managershop.exception.NullException;
import com.example.managershop.exception.RessourseNotFounfException;
import com.example.managershop.service.CategorieService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
//@AllArgsConstructor
public class CategorieServiceImpl implements CategorieService {

    @Autowired
    private CategorieService categorieService ;
    @Autowired
    private CategoryRepository categoryRepository ;

   /* public CategorieServiceImpl(CategorieService categorieService, CategoryRepository categoryRepository) {
        this.categorieService = categorieService;
        this.categoryRepository = categoryRepository;
    }*/

    @Override
    public Categorie findByIdcat(String idcat) throws RessourseNotFounfException {
        if(!categoryRepository.findById(idcat).isPresent()) throw new RessourseNotFounfException("Categorie with id :"+idcat+ "not found");
        return categoryRepository.findById(idcat).get();
    }

    @Override
    public Categorie addCategory(Categorie c) throws NullException {
        c.setIdCat(UUID.randomUUID().toString());
        return categoryRepository.save(c);
    }

    @Override
    public boolean isExistCat(String idcat) {
        return categoryRepository.findById(idcat).isPresent();
    }

    @Override
    public Categorie updateCat(String idCat, Categorie newCat) throws CategorieNotFoundException, RessourseNotFounfException {
        if (!isExistCat(idCat)) throw new RessourseNotFounfException("Categorie with id ID :"+idCat+" not found");
        findByIdcat(idCat).setNomCat(newCat.getNomCat());
        findByIdcat(idCat).setArchived(newCat.getArchived());
        return categoryRepository.save(findByIdcat(idCat));
    }

    @Override
    public Categorie deleteCat(String idCat) throws RessourseNotFounfException {
        if(!isExistCat(idCat)) throw new RessourseNotFounfException("Categorie with id ID :"+idCat+" not found");
        Categorie cate = categoryRepository.findById(idCat).get();
        categoryRepository.delete(findByIdcat(idCat));
        return cate;
    }

    @Override
    public List<Categorie> findAll(String keyword) {
        return categoryRepository.findAll(keyword);
    }

    @Override
    public List<Categorie> findAll() {
        return categoryRepository.findAll();
    }



    @Override
    public Categorie addProductToCategorie(Long idPdt, String idCat) {

        return null;
    }

    @Override
    public Categorie deleteProductToCategorie(Long idPdt, String idCat) {
        return null;
    }

    @Override
    public Categorie deleteProductToCategorie(List<Produit> produits, String idCat) {
        return null;
    }


   /* @Override
    public Categorie findByIdcat(Long idcat) {
        if(ObjectUtils.nullSafeEquals(categoryRepository.findByIdCat(idcat),null)) return null;
        return categoryRepository.findById(idcat).get();
    }*/

    /*@Override
    public Categorie findByIdcat(String idcat) throws RessourseNotFounfException {
        if(ObjectUtils.nullSafeEquals(categoryRepository.findById(idcat),null)) throw  new RessourseNotFounfException("Categorie with id :"+idcat+" Not found");
        return categoryRepository.findById(idcat).get();
        //categoryRepository.fi
    }


    @Override
    public Categorie addCategory(Categorie c) throws NullException {
        //if(ObjectUtils.nullSafeEquals(c, null)) throw new NullException("Categorie is empty");
        if(c.getNomCat().equals(null)) {throw new NullException("Categorie should be not empty");}
        return this.categoryRepository.save(c);
    }

    @Override
    public boolean isExistCat(String idCat) {
        return false;
    }

    @Override
    public Categorie updateCat(String idCat, Categorie newCat) throws CategorieNotFoundException, RessourseNotFounfException {
        return null;
    }

    @Override
    public Categorie deleteCat(String idCat) throws CategorieNotFoundException, RessourseNotFounfException {
        return null;
    }

    @Override
    public boolean isExistCat(Long idCat) {
        return categoryRepository.existsById(idCat);
    }

    @Override
    public Categorie updateCat(Long idCat, Categorie newCat) throws RessourseNotFounfException {
        if(ObjectUtils.nullSafeEquals(findByIdcat(idCat),null)) return null;
        if(ObjectUtils.nullSafeEquals(newCat,null)){
            return categoryRepository.findById(idCat).get();
        }
        findByIdcat(idCat).setNomCat(newCat.getNomCat());
        findByIdcat(idCat).setArchived(newCat.getArchived());
        return categoryRepository.save(findByIdcat(idCat));

    }

    @Override
    public Categorie deleteCat(Long idCat) throws RessourseNotFounfException {
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
    public Categorie searchCatById(String id) {
        return null;
    }


    @Override
    public Categorie searchCatById(Long id) {
        return categoryRepository.findByIdCat(id);
    }

    @Override
    public Categorie searchCatById1(String id) {
        if(categoryRepository.findById(id).isPresent())
           return categoryRepository.findById(id).get();
        else return null;
    }
*/

}
