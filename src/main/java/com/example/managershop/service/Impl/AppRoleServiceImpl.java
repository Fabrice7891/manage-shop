package com.example.managershop.service.Impl;

import com.example.managershop.dao.AppRoleRepository;
import com.example.managershop.dto.AppRoleDto;
import com.example.managershop.dto.Map.MapperEntities;
import com.example.managershop.entities.AppRole;
import com.example.managershop.exception.RessourseNotFounfException;
import com.example.managershop.service.AppRoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class AppRoleServiceImpl implements AppRoleService {

    private final AppRoleRepository appRoleRepository;
    private final MapperEntities mapperEntities;
    @Override
    public AppRole saveRole(AppRoleDto appRoleDto) throws RessourseNotFounfException {
        AppRole appRole = mapperEntities.AppRoleDTOAppRole(appRoleDto);
        String idroleGenreted = UUID.randomUUID().toString();
        int i = 0;
        while (i < 5 && !ObjectUtils.isEmpty(appRoleRepository.findByIdRole(idroleGenreted))) {
            i++;
            idroleGenreted = UUID.randomUUID().toString();
            System.out.println("----------" + idroleGenreted);
        }

        if (!ObjectUtils.isEmpty(appRoleRepository.findByIdRole(idroleGenreted))) {
            log.error("Role dont save because id dont genereted");
            throw new RessourseNotFounfException("Role dont save because id role dont generated");
        }

        //if(!appRoleRepository.findByIdRole(idroleGenreted).equals(null)) throw new RuntimeException("id genereted "+ idroleGenreted+" already exist");
        appRole.setIdRole(idroleGenreted);
        log.info("Role {} saved with success", appRoleRepository.save(appRole) );
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
