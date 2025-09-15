package com.microsvs.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.microsvs.product.dto.InventoryResponseDTO;
import com.microsvs.product.entity.Product;
import com.microsvs.product.repository.ProductRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductService {
	private final ProductRepository repository;

	private final InventoryClientService iClientService;

	public ProductService(ProductRepository repository, InventoryClientService iClientService) {
		this.repository = repository;
		this.iClientService = iClientService;
	}

	public List<Product> getAllProducts() {
		return repository.findAll();
	}

	public Product getProductById(Long id) {
		return repository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
	}

	public Product createProduct(Product product) {
		Product saveProduct = repository.save(product);

		InventoryResponseDTO inventoryResponse = iClientService.addInventory(InventoryResponseDTO.builder()
				.productId(saveProduct.getId()).quantity(product.getStock()).threshold(10).build());
		saveProduct.setStock(inventoryResponse.getQuantity());

		return saveProduct;
	}

	public void deleteProduct(Long id) {
		repository.deleteById(id);
	}
}
