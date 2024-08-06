package com.ayushi.BlogApplication.services.implementations;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayushi.BlogApplication.entities.Category;
import com.ayushi.BlogApplication.exceptions.ResourceNotFoundException;
import com.ayushi.BlogApplication.payloads.CategoryDto;
import com.ayushi.BlogApplication.repository.CategoryRepo;
import com.ayushi.BlogApplication.services.CategoryService;

@Service
public class CategoryServiceImple implements CategoryService{
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
	
		Category newCategory= this.modelMapper.map(categoryDto, Category.class);
		Category createdCategory= categoryRepo.save(newCategory);
		
		return this.modelMapper.map(createdCategory, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategoryDto(CategoryDto categoryDto, Integer categoryId) {
		
		Category newCategory= this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category", "categoryId", categoryId));
		
		newCategory.setCategoryName(categoryDto.getCategoryName());
		newCategory.setCategoryDescription(categoryDto.getCategoryDescription());
		Category createdCategory= categoryRepo.save(newCategory);
		
		return this.modelMapper.map(createdCategory, CategoryDto.class);
	}

	@Override
	public CategoryDto getCategoryById(Integer categoryId) {
		
		Category newCategory= this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category", "categoryId", categoryId));
		
		return this.modelMapper.map(newCategory, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getAllCategories() {
		
		List<Category> categories= this.categoryRepo.findAll();
		List<CategoryDto> categoryDtos= categories.stream().map((category)->this.modelMapper.map(category, CategoryDto.class)).collect(Collectors.toList());
		
		return categoryDtos;
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		
		this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category", "categoryId", categoryId));
		categoryRepo.deleteById(categoryId);
		
	}

}
