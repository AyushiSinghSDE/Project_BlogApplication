package com.ayushi.BlogApplication.entities;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Category {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer categoryId;
private String categoryName;
private String categoryDescription;

@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
private List<Post> posts= new ArrayList<>();
	
}
