package com.microsvs.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.microsvs.product.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query("SELECT p FROM Product p WHERE p.category.parent.name = :parentName OR p.category.name = :parentName")
	List<Product> findProductsByCategoryOrParent(@Param("parentName") String parentName);

}
