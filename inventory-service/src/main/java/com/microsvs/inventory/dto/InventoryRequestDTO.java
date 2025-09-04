package com.microsvs.inventory.dto;

import java.util.UUID;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InventoryRequestDTO {
	@NotNull
	private UUID productId;

	@Min(0)
	private int quantity;

	private int threshold;
}
