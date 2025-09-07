package com.microsvs.product.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microsvs.product.dto.CategoryDTO;
import com.microsvs.product.entity.Category;
import com.microsvs.product.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDTO createCategory(CategoryDTO categoryDTO) {
		Category category = modelMapper.map(categoryDTO, Category.class);

		if (categoryDTO.getParentId() != null) {
			Category parent = categoryRepository.findById(categoryDTO.getParentId())
					.orElseThrow(() -> new RuntimeException("Parent category not found"));
			category.setParent(parent);
		}

		Category saved = categoryRepository.save(category);
		return modelMapper.map(saved, CategoryDTO.class);
	}

	@Override
	public List<CategoryDTO> getAllCategories() {
		return categoryRepository.findAll().stream().map(category -> {
			CategoryDTO dto = modelMapper.map(category, CategoryDTO.class);
			dto.setParentId(category.getParent() != null ? category.getParent().getId() : null);
			return dto;
		}).collect(Collectors.toList());
	}

	@Override
	public CategoryDTO getCategoryById(Long id) {
		Category category = categoryRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Category not found"));
		CategoryDTO dto = modelMapper.map(category, CategoryDTO.class);
		dto.setParentId(category.getParent() != null ? category.getParent().getId() : null);
		return dto;
	}

	@Override
	public CategoryDTO updateCategory(Long id, CategoryDTO categoryDTO) {
		Category category = categoryRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Category not found"));

		category.setName(categoryDTO.getName());

		if (categoryDTO.getParentId() != null) {
			Category parent = categoryRepository.findById(categoryDTO.getParentId())
					.orElseThrow(() -> new RuntimeException("Parent category not found"));
			category.setParent(parent);
		} else {
			category.setParent(null);
		}

		Category updated = categoryRepository.save(category);
		CategoryDTO dto = modelMapper.map(updated, CategoryDTO.class);
		dto.setParentId(updated.getParent() != null ? updated.getParent().getId() : null);
		return dto;
	}

	@Override
	public void deleteCategory(Long id) {
		if (!categoryRepository.existsById(id)) {
			throw new RuntimeException("Category not found");
		}
		categoryRepository.deleteById(id);
	}
}
