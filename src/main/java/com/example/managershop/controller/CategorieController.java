package com.example.managershop.controller;

import com.example.managershop.dao.CategoryRepository;
import com.example.managershop.entities.Categorie;
import com.example.managershop.exception.CategorieNotFoundException;
import com.example.managershop.service.CategorieService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorie")
public class CategorieController {

    @Autowired
    private CategorieService categorieService;

    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping("/")
    @ApiOperation(value = "Create a Category")
    public Categorie AddCategorie(@RequestBody Categorie categorie){
             return categorieService.addCategory(categorie);
    }

    @GetMapping("/")
    public List<Categorie> getAllCategories(){
        return categorieService.findAll();
    }

    @GetMapping("/{id}")
    public Categorie getCatById(@PathVariable("id") Long idCat){
        System.out.println("------------"+categoryRepository.findByIdCat(idCat));
       return categorieService.findByIdcat(idCat);

    }

    @DeleteMapping("/{id}")
    public void deleteCat(@PathVariable("id") Long idCat){
        categorieService.deleteCat(idCat);
    }

    @PutMapping("/{id}")
    public void updateCat(@PathVariable("id") Long idCat, @RequestBody Categorie categorie) throws CategorieNotFoundException {
        categorieService.updateCat(idCat,categorie);
    }
}
