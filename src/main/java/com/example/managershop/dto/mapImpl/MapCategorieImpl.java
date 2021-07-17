package com.example.managershop.dto.mapImpl;

import com.example.managershop.dto.CategorieDto;
import com.example.managershop.dto.Map.MapCategorie;
import com.example.managershop.dto.RoleDto;
import com.example.managershop.entities.Categorie;
import com.example.managershop.entities.Role;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MapCategorieImpl implements MapCategorie {

   // @Autowired
    private ModelMapper modelMapper;

    public MapCategorieImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public Categorie categorieDtoToCategorie(CategorieDto categorieDto) {
        Categorie categorie= modelMapper.map(categorieDto,Categorie.class);
        return categorie;
    }

    @Override
    public CategorieDto categorieToCategorieDt(Categorie categorie) {

        return  modelMapper.map(categorie, CategorieDto.class);
    }

    @Override
    public Role roleDtoTorole(RoleDto roleDto) {
        return modelMapper.map(roleDto, Role.class);
    }

    @Override
    public RoleDto roleToroleDto(Role role) {
        return modelMapper.map(role, RoleDto.class);
    }
}
