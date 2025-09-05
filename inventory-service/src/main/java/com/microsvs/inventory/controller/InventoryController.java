package com.microsvs.inventory.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microsvs.inventory.dto.InventoryRequestDTO;
import com.microsvs.inventory.dto.InventoryResponseDTO;
import com.microsvs.inventory.service.InventoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/inventory")
public class InventoryController {

	@Autowired
	private InventoryService inventoryService;

	@GetMapping("/{productId}")
	public ResponseEntity<InventoryResponseDTO> getInventory(@PathVariable UUID productId) {
		InventoryResponseDTO responseDTO = inventoryService.getStock(productId);
		return ResponseEntity.ok(responseDTO);
	}

	@PutMapping("/{productId}")
	public ResponseEntity<InventoryResponseDTO> updateInventory(@PathVariable UUID productId,
			@RequestParam int quantity) {
		InventoryResponseDTO responseDTO = inventoryService.updateStock(productId, quantity);
		return ResponseEntity.ok(responseDTO);
	}

	@PostMapping
	public ResponseEntity<InventoryResponseDTO> addInventory(@Valid @RequestBody InventoryRequestDTO requestDTO) {
		InventoryResponseDTO responseDTO = inventoryService.addInventory(requestDTO);
		return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
	}

	@GetMapping("/low-stock")
	public ResponseEntity<List<InventoryResponseDTO>> getLowStockItems() {
		List<InventoryResponseDTO> lowStockItems = inventoryService.getLowStockItems();
		return ResponseEntity.ok(lowStockItems);
	}
}
