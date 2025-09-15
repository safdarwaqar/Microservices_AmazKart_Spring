package com.microsvs.product.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.microsvs.product.dto.InventoryResponseDTO;

import jakarta.validation.Valid;

@FeignClient(name = "inventory-service", path = "/api/v1/inventory")
public interface InventoryClientService {

	@GetMapping("/{productId}")
	public InventoryResponseDTO getInventory(@PathVariable Long productId);

	@PutMapping("/{productId}")
	public InventoryResponseDTO updateInventory(@PathVariable Long productId, @RequestParam int quantity);

	@PostMapping
	public InventoryResponseDTO addInventory(@Valid @RequestBody InventoryResponseDTO requestDTO);

	@GetMapping("/low-stock")
	public ResponseEntity<List<InventoryResponseDTO>> getLowStockItems();

}
