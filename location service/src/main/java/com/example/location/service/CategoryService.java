package com.example.location.service;

import com.example.location.model.Category;
import com.example.location.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public Category findCategoryByName(String name) {
        return categoryRepository.findCategoryByName(name);
    }

}
