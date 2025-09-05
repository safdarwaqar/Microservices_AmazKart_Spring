package com.microsvs.inventory.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class InventoryResponseDTO {
	private UUID productId;
	private int quantity;
	private int threshold;
	private LocalDateTime lastUpdated;
}
