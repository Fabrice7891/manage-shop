package com.example.managershop.service.Impl;

import com.example.managershop.dao.FounisseurRepository;
import com.example.managershop.dto.FournisseurDto;
import com.example.managershop.dto.Map.MapperEntities;
import com.example.managershop.entities.Fournisseur;
import com.example.managershop.exception.NullException;
import com.example.managershop.service.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
public class FournisseurServiceImpl implements FournisseurService {
    @Autowired
    private FounisseurRepository founisseurRepository;
    @Autowired
    private MapperEntities mapperEntities;

    @Override
    public Fournisseur addfounisseur(FournisseurDto fournisseurDto) throws NullException {
        if(fournisseurDto.getNameFsseur().equals(null)
        || fournisseurDto.getPhoneFsseur().equals(null)
        || fournisseurDto.getAddresseFsseur().equals(null)
        || fournisseurDto.getPaysFsseur().equals(null)
        || fournisseurDto.getVilleFsseur().equals(null)) throw new NullException("Must have a value");
        Fournisseur fournisseur=mapperEntities.FournisserDTOFournisseur(fournisseurDto);
        //fournisseur.setIdFsseur(UUID.randomUUID().toString());
        founisseurRepository.save(fournisseur);
        return fournisseur;
    }
}
