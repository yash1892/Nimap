package com.ty.Category_Product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.Category_Product.dto.Product;

public interface Product_repo extends JpaRepository<Product, Integer>{

}
