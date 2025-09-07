package com.microsvs.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.microsvs.product.entity.Product;
import com.microsvs.product.repository.ProductRepository;

@Service
public class ProductService {
	private final ProductRepository repository;

	public ProductService(ProductRepository repository) {
		this.repository = repository;
	}

	public List<Product> getAllProducts() {
		return repository.findAll();
	}

	public Product getProductById(Long id) {
		return repository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
	}

	public Product createProduct(Product product) {
		return repository.save(product);
	}

	public void deleteProduct(Long id) {
		repository.deleteById(id);
	}
}
