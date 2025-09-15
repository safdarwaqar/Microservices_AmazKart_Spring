package com.microsvs.product.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class InventoryResponseDTO {
	private Long productId;
	private int quantity;
	private int threshold;
	private LocalDateTime lastUpdated;
}
