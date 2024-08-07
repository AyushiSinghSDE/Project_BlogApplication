package com.ayushi.BlogApplication.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ayushi.BlogApplication.entities.Category;
import com.ayushi.BlogApplication.payloads.CategoryDto;
import com.ayushi.BlogApplication.repository.CategoryRepo;
import com.ayushi.BlogApplication.services.CategoryService;

@RestController
@RequestMapping("blog/category")
public class CategoryController {
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createcategory(@RequestBody CategoryDto categoryDto)
	{
		CategoryDto newCategoryDto= categoryService.createCategory(categoryDto);
		return new ResponseEntity<CategoryDto>(newCategoryDto, HttpStatus.OK);
	}
	
	
	@PutMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> updatecategory(@RequestBody CategoryDto categoryDto, @PathVariable Integer categoryId)
	{
		CategoryDto newCategoryDto=categoryService.updateCategoryDto(categoryDto, categoryId);
		return new ResponseEntity<CategoryDto>(newCategoryDto, HttpStatus.OK);
	}
	
	
	@GetMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> getcategory(@PathVariable Integer categoryId)
	{
		CategoryDto newCategoryId=categoryService.getCategoryById(categoryId);
		return new ResponseEntity<CategoryDto>(newCategoryId,HttpStatus.OK);
	}
	
	
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getAllCatgeories()
	{
		List<CategoryDto> categories= categoryService.getAllCategories();
		return new ResponseEntity<List<CategoryDto>>(categories,HttpStatus.OK);
	}

	
	@DeleteMapping("/{categoryId}")
	public ResponseEntity<Void> deletecategory(Integer categoryId)
	{
		categoryService.deleteCategory(categoryId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
