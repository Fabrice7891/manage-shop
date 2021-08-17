package com.example.managershop.service.Impl;

import com.example.managershop.dao.CategoryRepository;
import com.example.managershop.dao.ProduitRepository;
import com.example.managershop.dto.Map.MapperEntities;
import com.example.managershop.dto.ProduitDto;
import com.example.managershop.entities.Produit;
import com.example.managershop.exception.RessourseNotFounfException;
import com.example.managershop.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProduitServiceImpl implements ProduitService {
    @Autowired
    private ProduitRepository produitRepository;

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private MapperEntities mapperEntities;
    @Override
    public Produit savePdt(String idCat, ProduitDto produitDto) throws RessourseNotFounfException {
        if(!categoryRepository.findById(idCat).isPresent()) throw new
                RessourseNotFounfException("Category with Id :"+idCat+" not found");
        Produit produit= mapperEntities.ProduitDTOProduit(produitDto);
        produit.setCategorie(categoryRepository.findById(idCat).get());
        produitRepository.save(produit);
        return produit;
    }

    @Override
    public Produit deletePdt(Long idPdt) throws RessourseNotFounfException {
        if(!produitRepository.findById(idPdt).isPresent()) throw new RessourseNotFounfException("Product with Id :"+idPdt+" not found");
        Produit produit=produitRepository.findById(idPdt).get();
        produitRepository.delete(produitRepository.findById(idPdt).get());
        return produit;
    }

    @Override
    public Produit updadePdt(Long idPdt, ProduitDto produitDto) {
        return null;
    }

    @Override
    public Produit getPdtById(Long idPdt) throws RessourseNotFounfException {
        if(!produitRepository.findById(idPdt).isPresent()) throw new RessourseNotFounfException("Product with id :"+idPdt+" not not exist");
        return produitRepository.findById(idPdt).get();
    }

    @Override
    public List<Produit> searchPdtByName(String namePdt) throws RessourseNotFounfException {
        if (produitRepository.searchPdtByKeyword(namePdt).isEmpty()) throw new RessourseNotFounfException("is empty");
        return produitRepository.searchPdtByKeyword(namePdt);
    }

    @Override
    public List<Produit> getAllPdt() {
        return produitRepository.findAll();
    }
}
