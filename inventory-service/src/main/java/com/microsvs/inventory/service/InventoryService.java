package com.microsvs.inventory.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microsvs.inventory.dto.InventoryRequestDTO;
import com.microsvs.inventory.dto.InventoryResponseDTO;
import com.microsvs.inventory.entity.InventoryItem;
import com.microsvs.inventory.exception.ResourceNotFoundException;
import com.microsvs.inventory.repository.InventoryRepository;

@Service
public class InventoryService {

	@Autowired
	private InventoryRepository inventoryRepository;

	public InventoryResponseDTO addInventory(InventoryRequestDTO requestDTO) {

		if (inventoryRepository.findByProductId(requestDTO.getProductId()).isPresent()) {
			throw new IllegalArgumentException("Inventory already exists for productId: " + requestDTO.getProductId());
		}

		InventoryItem item = new InventoryItem();
		item.setProductId(requestDTO.getProductId());
		item.setQuantity(requestDTO.getQuantity());
		item.setThreshold(requestDTO.getThreshold());

		InventoryItem saved = inventoryRepository.save(item);
		return mapToDTO(saved);
	}

	public List<InventoryResponseDTO> getLowStockItems() {
		List<InventoryItem> items = inventoryRepository.findAll();
		return items.stream().filter(item -> item.getQuantity() <= item.getThreshold()).map(this::mapToDTO)
				.collect(Collectors.toList());
	}

	public InventoryResponseDTO getStock(Long productId) {
		InventoryItem item = inventoryRepository.findByProductId(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Inventory not found for productId: " + productId));
		return mapToDTO(item);
	}

	public InventoryResponseDTO updateStock(Long productId, int quantity) {
		InventoryItem item = inventoryRepository.findByProductId(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Inventory not found for productId: " + productId));
		item.setQuantity(quantity);
		InventoryItem updated = inventoryRepository.save(item);
		return mapToDTO(updated);
	}

	private InventoryResponseDTO mapToDTO(InventoryItem item) {
		InventoryResponseDTO dto = new InventoryResponseDTO();
		dto.setProductId(item.getProductId());
		dto.setQuantity(item.getQuantity());
		dto.setThreshold(item.getThreshold());
		dto.setLastUpdated(item.getLastUpdated());
		return dto;
	}
}
