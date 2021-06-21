package com.example.managershop;

import com.example.managershop.entities.Categorie;
import com.example.managershop.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.stream.Stream;

@SpringBootApplication
//@EnableSwagger2
public class ManagerShopApplication //implements CommandLineRunner
{

	@Autowired
	private CategorieService categorieService;
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
}
