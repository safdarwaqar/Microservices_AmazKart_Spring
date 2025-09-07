package com.microsvs.product.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {

	private Long id;
	private String name;
	private String description;
	private BigDecimal price;
	private int stockQuantity;

	// Just return category info
	private CategoryDTO category;
}
