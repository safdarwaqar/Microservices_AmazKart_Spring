package com.microsvs.inventory.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InventoryRequestDTO {
	@NotNull
	private Long productId;

	@Min(1)
	private int quantity;

	private int threshold;
}
