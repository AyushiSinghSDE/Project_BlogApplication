package com.ayushi.BlogApplication.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class category {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int categoryId;
private String categoryName;
private String categoryDescription;
	
}