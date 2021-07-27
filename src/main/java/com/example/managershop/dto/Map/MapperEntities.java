package com.example.managershop.dto.Map;

import com.example.managershop.dto.FournisseurDto;
import com.example.managershop.entities.Fournisseur;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapperEntities {
    public Fournisseur FournisserDTOFournisseur(FournisseurDto fournisseurDto);
    public FournisseurDto FournisserToFournisseurDTO(Fournisseur fournisseur);
}
