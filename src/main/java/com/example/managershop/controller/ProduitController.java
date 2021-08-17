package com.example.managershop.controller;

import com.example.managershop.dto.CategorieDto;
import com.example.managershop.dto.ProduitDto;
import com.example.managershop.entities.Categorie;
import com.example.managershop.entities.Fournisseur;
import com.example.managershop.entities.Produit;
import com.example.managershop.exception.NullException;
import com.example.managershop.exception.RessourseNotFounfException;
import com.example.managershop.service.ProduitService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/produits")
public class ProduitController {

    @Autowired
     private ProduitService produitService;

    @PostMapping("/{idCat}")
    @ApiOperation(value = "Create a Produit")
    public ResponseEntity<Produit> createPdt(@PathVariable String idCat, @Valid @RequestBody ProduitDto produitDto) throws NullException, RessourseNotFounfException {
        return new ResponseEntity<>(produitService.savePdt(idCat, produitDto), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Produit>> getAllPdt() {
        return new ResponseEntity<>(produitService.getAllPdt(), HttpStatus.OK);
    }

    @GetMapping("/key")
    public ResponseEntity<List<Produit>> getAllPdt(@RequestParam String keyword) throws RessourseNotFounfException {
        return new ResponseEntity<>(produitService.searchPdtByName(keyword), HttpStatus.OK);
    }


}
