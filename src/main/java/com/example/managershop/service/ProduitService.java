package com.example.managershop.service;

import com.example.managershop.dto.ProduitDto;
import com.example.managershop.entities.Produit;
import com.example.managershop.exception.RessourseNotFounfException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public interface ProduitService {
    public Produit savePdt(String idCat , ProduitDto produitDto) throws RessourseNotFounfException;
    public Produit deletePdt(Long idPdt) throws RessourseNotFounfException;
    public Produit updadePdt(Long idPdt , ProduitDto newPdtProduitDto);
    public Produit getPdtById(Long idPdt) throws RessourseNotFounfException;
    public List<Produit> searchPdtByName(String namePdt) throws RessourseNotFounfException;
    public List<Produit> getAllPdt();
}
