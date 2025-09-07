package com.microsvs.product.controller;

import org.springframework.web.bind.annotation.*;

import com.microsvs.product.entity.Product;
import com.microsvs.product.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	private final ProductService service;

	public ProductController(ProductService service) {
		this.service = service;
	}

	@GetMapping
	public List<Product> getAll() {
		return service.getAllProducts();
	}

	@GetMapping("/{id}")
	public Product getById(@PathVariable Long id) {
		return service.getProductById(id);
	}

	@PostMapping
	public Product create(@RequestBody Product product) {
		return service.createProduct(product);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.deleteProduct(id);
	}
}
