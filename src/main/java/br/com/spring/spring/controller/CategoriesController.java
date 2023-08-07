package br.com.spring.spring.controller;

import br.com.spring.spring.domain.Category;
import br.com.spring.spring.domain.CategoryRepository;
import br.com.spring.spring.domain.RequestCategoriesDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class CategoriesController {

    @Autowired
    private CategoryRepository repository;

    @GetMapping
    public ResponseEntity getAllCategories(){
        var allCategories = repository. findAll();

        return  ResponseEntity.ok(allCategories);
    };

    @PostMapping("/register")
    public ResponseEntity registerCategories(@RequestBody @Valid RequestCategoriesDTO data) {
        Category newCategory = new Category(data);
        repository.save(newCategory);
        return ResponseEntity.ok().build();
    }






}
