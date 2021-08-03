package com.example.managershop.config;

import com.example.managershop.entities.Categorie;
import com.example.managershop.exception.NullException;
import com.example.managershop.service.CategorieService;
import com.example.managershop.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.stream.Stream;

@Configuration
public class RunnerConfig {

    @Autowired
    private CategorieService categorieService;
    @Autowired
    private RoleService roleService;

    @Bean
    CommandLineRunner start(/*AccountService accountService, RoleService roleService, CategorieService categorieService*/){
        return  args -> {

			/*Stream.of("Role1","Role2","Role3","Role4","Role5").forEach(r->{
				    accountService.save(Role.builder().nameRole(r).levelPriorite((int)(Math.random() * 6)).build());
*/
            Stream.of("Categorie1","Categorie2","Categorie3","Categorie4","Categorie5","Categorie6").forEach(c->{
                try {
                    categorieService.addCategory(Categorie.builder().nomCat(c).archived(false).build());
                } catch (NullException e) {
                    e.printStackTrace();
                }
            });

            categorieService.findAll().forEach(cat->{
                System.out.println(cat.getNomCat());

                //System.out.println(mapEntityToDto.CategorieToCategorieDTO(new Categorie("test")).toString());
            });

        };
    }
}
