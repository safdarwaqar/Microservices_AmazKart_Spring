package com.microsvs.product.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDTO {

	private Long id;
	private String name;

	// Only parent id (to avoid recursion)
	private Long parentId;

	// Optional: If you want to return subcategories in a tree structure
	private List<CategoryDTO> subCategories;
}