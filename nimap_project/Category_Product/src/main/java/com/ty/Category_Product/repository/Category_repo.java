package com.ty.Category_Product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.Category_Product.dto.Category;

public interface Category_repo extends JpaRepository<Category, Integer>{

}
