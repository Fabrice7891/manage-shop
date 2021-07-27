package com.example.managershop.controller;

import com.example.managershop.dto.CategorieDto;
import com.example.managershop.dto.FournisseurDto;
import com.example.managershop.entities.Categorie;
import com.example.managershop.entities.Fournisseur;
import com.example.managershop.exception.NullException;
import com.example.managershop.service.FournisseurService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/fournisseurs")
public class FournisseurController {

    @Autowired
    private FournisseurService fournisseurService;

    @PostMapping("/")
    @ApiOperation(value = "Create a Fournisseur")
    public ResponseEntity<Fournisseur> createFornisseur(@Valid @RequestBody FournisseurDto fournisseurDto) throws NullException {
        return new ResponseEntity<>(fournisseurService.addfounisseur(fournisseurDto), HttpStatus.CREATED);
    }
}
