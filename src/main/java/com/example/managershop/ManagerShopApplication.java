package com.example.managershop;

import com.example.managershop.entities.Categorie;
import com.example.managershop.exception.NullException;
import com.example.managershop.service.CategorieService;
import com.example.managershop.service.RoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.stream.Stream;

@SpringBootApplication //(exclude = SecurityAutoConfiguration.class)
//@EnableSwagger2
public class ManagerShopApplication //implements CommandLineRunner
{

	@Autowired
	private CategorieService categorieService;
	@Autowired
	private RoleService roleService;

	/*public ManagerShopApplication(CategorieService categorieService, RoleService roleService) {
		this.categorieService = categorieService;
		this.roleService = roleService;
	}*/

	/*public ManagerShopApplication(CategorieService categorieService, RoleService roleService) {
		this.categorieService = categorieService;
		this.roleService = roleService;
	}*/


	public static void main(String[] args) {
		SpringApplication.run(ManagerShopApplication.class, args);
	}

	/*@Override
	public void run(String... args) throws Exception {
		Stream.of("Cat1","Cat2","Cat3").forEach(c->{
			categorieService.addCategory(new Categorie(null,c));
		});

		categorieService.showAllCat().forEach(cat->{
			System.out.println(cat.getNomCat());
		});
	}*/

	@Bean
	CommandLineRunner start(/*AccountService accountService, RoleService roleService*/){
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


	@Bean
	public BCryptPasswordEncoder getBCPE(){  // crypte les mdp
		return  new BCryptPasswordEncoder();
	}

	@Bean
	public ModelMapper mapper(){
		return  new ModelMapper();
	}
}
