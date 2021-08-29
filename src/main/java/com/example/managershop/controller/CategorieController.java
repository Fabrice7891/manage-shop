package com.example.managershop.controller;

import com.example.managershop.dao.CategoryRepository;
import com.example.managershop.dto.CategorieDto;
import com.example.managershop.dto.Map.MapAll;
import com.example.managershop.entities.Categorie;
import com.example.managershop.entities.Produit;
import com.example.managershop.exception.CategorieNotFoundException;
import com.example.managershop.exception.NullException;
import com.example.managershop.exception.RessourseNotFounfException;
import com.example.managershop.service.CategorieService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/categorie")
public class CategorieController {

    @Autowired
    private CategorieService categorieService;

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private MapAll mapAll;

    /*@PostMapping("/")
    @ApiOperation(value = "Create a Category")
    public ResponseEntity<Categorie> createCategorie(@Valid @RequestBody Categorie categorie) {
        return new ResponseEntity<>(categorieService.addCategory(categorie), HttpStatus.CREATED);
    }*/

    @PostMapping
    @ApiOperation(value = "Create a Category")
    public ResponseEntity<Categorie> createCategorieDTO(@Valid @RequestBody CategorieDto categorieDto) throws NullException {
        return new ResponseEntity<>(categorieService.addCategory(mapAll.categorieDtoToCategorie(categorieDto)), HttpStatus.CREATED);
    }


    @PostMapping("/{idPdt}/{idCat}")
    @ApiOperation(value = "Create a Category")
    public ResponseEntity<Categorie> AddPdtToCategorie(@PathVariable String idCat, @PathVariable String idPdt) throws RessourseNotFounfException {
        return new ResponseEntity<>(categorieService.addProductToCategorie(idPdt,idCat), HttpStatus.OK);
    }

    /*@PostMapping("/")
    @ApiOperation(value = "Create a Category")
    public Categorie createCategorie(@Valid @RequestBody Categorie categorie) throws NullException {
        return categorieService.addCategory(categorie);
    }*/


    @GetMapping
    public ResponseEntity<List<Categorie>> getAllCategories() {
        return new ResponseEntity<>(categorieService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/listSort")
    public ResponseEntity<List<Categorie>> getAllCategoriesSort() {
        return new ResponseEntity<>(categorieService.findAllSort(), HttpStatus.OK);
    }

    @GetMapping("/page/{pageNo}")
    public ResponseEntity<Page<Categorie>> getAllCategoriesPagined(@PathVariable("pageNo") int pageNo
    , @RequestParam ("sortField") String sortField
            ,@RequestParam("sortDirec") String sortDirec) {
        int size=3;
        return new ResponseEntity<>(categorieService.listePaginedCategorie(pageNo, size,sortField,sortDirec), HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<Categorie> getCatById(@PathVariable("id") String id) throws RessourseNotFounfException {
        return new ResponseEntity<>(categorieService.findByIdcat(id), HttpStatus.OK);
    }



    @DeleteMapping
    public ResponseEntity<Categorie> deleteCat(@PathVariable("id") String id) throws CategorieNotFoundException, RessourseNotFounfException {
        return new ResponseEntity<>(categorieService.deleteCat(id), HttpStatus.OK);
    }


    @PutMapping
    public ResponseEntity<Categorie> updateCat(@PathVariable("id") String id, @Valid @RequestBody Categorie newCat) throws CategorieNotFoundException, RessourseNotFounfException {
        return new ResponseEntity<>(categorieService.updateCat(id, newCat), HttpStatus.OK);
    }

    @GetMapping("/products/{idCat}")
    public ResponseEntity<Collection<Produit>> getAllPdtByCategorie(@PathVariable String idCat) throws RessourseNotFounfException {
        return new ResponseEntity<>(categorieService.getProductByCategorie(idCat), HttpStatus.OK);
    }
}
