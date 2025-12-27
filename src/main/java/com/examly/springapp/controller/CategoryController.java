package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.Category;
import com.examly.springapp.repository.CategoryRepo;

@RestController
@RequestMapping("/api")
public class CategoryController {
    @Autowired
    private CategoryRepo categoryRepo;

    @PostMapping("/categories")
    @ResponseStatus(HttpStatus.CREATED)
    public Category addCategory(@RequestBody Category category) {
        return categoryRepo.save(category);
    }

    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }

    @GetMapping("/categories/{id}")
    public Category getCategoryById(@PathVariable long id) {
        return categoryRepo.findById(id).orElse(null);
    }
}
