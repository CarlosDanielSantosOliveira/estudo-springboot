package com.cursojava.spring.services;

import com.cursojava.spring.entities.Category;
import com.cursojava.spring.entities.Order;
import com.cursojava.spring.repositories.CategoryRepository;
import com.cursojava.spring.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(Long id) {
        Optional<Category> obj = categoryRepository.findById(id);
        return obj.get();
    }
}
