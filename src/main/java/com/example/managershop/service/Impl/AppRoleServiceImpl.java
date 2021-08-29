package com.example.managershop.service.Impl;

import com.example.managershop.dao.AppRoleRepository;
import com.example.managershop.dto.AppRoleDto;
import com.example.managershop.dto.Map.MapperEntities;
import com.example.managershop.entities.AppRole;
import com.example.managershop.exception.RessourseNotFounfException;
import com.example.managershop.service.AppRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class AppRoleServiceImpl implements AppRoleService {

    private final AppRoleRepository appRoleRepository;
    private final MapperEntities mapperEntities;
    @Override
    public AppRole saveRole(AppRoleDto appRoleDto) {
        AppRole appRole= mapperEntities.AppRoleDTOAppRole(appRoleDto);
        String idroleGenreted=UUID.randomUUID().toString();
        if(!appRoleRepository.findByIdRole(idroleGenreted).equals(null)) throw new RuntimeException("id genereted "+ idroleGenreted+" already exist");
        appRole.setIdRole(idroleGenreted);
        return appRoleRepository.save(appRole);
    }

    @Override
    public AppRole deleRole(String rolename) throws RessourseNotFounfException {
        AppRole appRole= appRoleRepository.findByRolename(rolename);
        if(appRole.equals(null)) throw new RessourseNotFounfException("Role with name"+rolename+" not found");
        appRoleRepository.delete(appRoleRepository.findByRolename(rolename));
        return appRole;
    }

    @Override
    public AppRole updateRole(String idrole, AppRoleDto appRoleDto) throws RessourseNotFounfException {
        if(!appRoleRepository.findById(idrole).isPresent()) throw
                new RessourseNotFounfException("Role with id"+idrole+" not found");
        AppRole appRole= appRoleRepository.findById(idrole).get();
        appRole.setRolename(appRoleDto.getRolename());
        return appRole;
    }

    @Override
    public Collection<AppRole> getAllRoles() {
        return appRoleRepository.findAll();
    }

    @Override
    public AppRole getRoleByRolename(String rolename) {
        return appRoleRepository.findByRolename(rolename);
    }

    @Override
    public Collection<AppRole> getAllRoleShorted() {
       return appRoleRepository.getALLRolleShorted();
    }
}
