package com.example.managershop.controller;

import com.example.managershop.entities.Categorie;
import com.example.managershop.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategorieController {

    @Autowired
    private CategorieService categorieService;

    @PostMapping("/savecategorie")
    public Categorie AddCategorie(@RequestBody Categorie categorie){
             return categorieService.addCategory(categorie);
    }

    @GetMapping("/listCategories")
    public List<Categorie> getAllCategories(){
        return categorieService.findAll();
    }

    @GetMapping("/categorie/{id}")
    public String getCatById(@PathVariable("id") Long idCat){

        Categorie cat= categorieService.findByIdcat(idCat);
        if(cat==null) return "Category not exist";
        return cat.toString()+"Deleted !!!";
    }

    @DeleteMapping("/deleteCat/{id}")
    public void deleteCat(@PathVariable("id") Long idCat){
        categorieService.deleteCat(idCat);
    }

    @PutMapping("/UpdateCat/{id}")
    public void updateCat(@PathVariable("id") Long idCat, @RequestBody Categorie categorie){
        categorieService.updateCat(idCat,categorie);
    }



}
