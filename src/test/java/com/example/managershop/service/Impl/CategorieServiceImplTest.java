package com.example.managershop.service.Impl;

import com.example.managershop.dao.CategoryRepository;
import com.example.managershop.entities.Categorie;
import com.example.managershop.service.CategorieService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class CategorieServiceImplTest {

    @MockBean
    private CategoryRepository categoryRepository;

    @Autowired
    private CategorieService categorieService;

    @Test
    void findByIdcatTest() {
    }

    @Test
    void addCategoryTest() {
    }

    @Test
    void isExistCatTest() {
    }

    @Test
    void updateCatTest() {
    }

    @Test
    void deleteCatTest() {
    }

    @Test
    void findAllTest() {
        Mockito.when(categoryRepository.findAll())
                .thenReturn(Stream.of(new Categorie(null,"te1"),new Categorie(null,"t2")).collect(Collectors.toList()));
        assertEquals(2, categorieService.findAll().size());
    }

    @Test
    void testFindAll() {
    }

    @Test
    void addProductToCategorieTest() {
    }

    @Test
    void deleteProductToCategorieTest() {
    }

    @Test
    void testDeleteProductToCategorieTest() {
    }

    @Test
    void getProductByCategorieTest() {
    }
}