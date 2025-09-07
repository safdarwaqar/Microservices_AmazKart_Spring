package com.microsvs.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microsvs.product.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
