package com.example.managershop.controller;

import com.example.managershop.entities.Categorie;
import com.example.managershop.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategorieController {

    @Autowired
    private CategorieService categorieService;

    @PostMapping("/savecategorie")
    public Categorie AddCategorie(@RequestBody Categorie categorie){
             return categorieService.addCategory(categorie);
    }
}
