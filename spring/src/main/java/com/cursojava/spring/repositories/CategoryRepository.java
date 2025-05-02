package com.cursojava.spring.repositories;

import com.cursojava.spring.entities.Category;
import com.cursojava.spring.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
