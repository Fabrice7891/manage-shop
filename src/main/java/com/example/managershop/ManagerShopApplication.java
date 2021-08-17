package com.example.managershop;

import com.example.managershop.dao.CategoryRepository;
import com.example.managershop.entities.Categorie;
import com.example.managershop.exception.NullException;
import com.example.managershop.service.AccountService;
import com.example.managershop.service.CategorieService;
import com.example.managershop.service.RoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.stream.Stream;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = {CategorieService.class , CategoryRepository.class})
//@EnableSwagger2
public class ManagerShopApplication //implements CommandLineRunner
{






	public static void main(String[] args) {
		SpringApplication.run(ManagerShopApplication.class, args);
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
