package br.com.spring.spring.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class CategoriesController {

    @GetMapping
    public ResponseEntity getAllCategories(){

        return null;
    };

    @PostMapping("/add")
    public ResponseEntity addCategories(){
        return null;
    }

    @PutMapping("/edit")
    public ResponseEntity editCategories(){
        return null;
    }


}
