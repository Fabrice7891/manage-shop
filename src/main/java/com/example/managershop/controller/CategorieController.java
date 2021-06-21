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
        return categorieService.showAllCat();
    }
}
