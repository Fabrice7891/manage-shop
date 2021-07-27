package com.example.managershop.dto.Map;

import com.example.managershop.dto.FournisseurDto;
import com.example.managershop.dto.ProduitDto;
import com.example.managershop.entities.Fournisseur;
import com.example.managershop.entities.Produit;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapperEntities {
    public Fournisseur FournisserDTOFournisseur(FournisseurDto fournisseurDto);
    public FournisseurDto FournisserToFournisseurDTO(Fournisseur fournisseur);

    public Produit ProduitDTOProduit(ProduitDto produitDto);
    public ProduitDto ProduitToProduitDTO(Produit Produit);
}

