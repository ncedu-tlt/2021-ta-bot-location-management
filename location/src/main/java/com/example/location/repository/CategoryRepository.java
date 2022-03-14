package com.example.location.repository;

import com.example.location.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, String> {

    Category findCategoryByName(String name);
}
