package com.ayushi.BlogApplication.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ayushi.BlogApplication.payloads.CategoryDto;

@Service
public interface CategoryService {
	
	CategoryDto createCategory(CategoryDto categoryDto);
	CategoryDto updateCategoryDto(CategoryDto categoryDto, int categoryId);
	CategoryDto getCategoryById(int categoryId);
	List<CategoryDto> getAllCategories();
	void deleteCategory(int categoryId);
}