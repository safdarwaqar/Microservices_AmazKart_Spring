package com.microsvs.product.service;

import java.util.List;

import com.microsvs.product.dto.CategoryDTO;

public interface CategoryService {
	CategoryDTO createCategory(CategoryDTO categoryDTO);

	List<CategoryDTO> getAllCategories();

	CategoryDTO getCategoryById(Long id);

	CategoryDTO updateCategory(Long id, CategoryDTO categoryDTO);

	void deleteCategory(Long id);
}
