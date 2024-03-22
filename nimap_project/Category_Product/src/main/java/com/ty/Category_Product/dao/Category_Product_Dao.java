package com.ty.Category_Product.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.ty.Category_Product.dto.Category;
import com.ty.Category_Product.dto.Product;
import com.ty.Category_Product.repository.Category_repo;
import com.ty.Category_Product.repository.Product_repo;

@Repository
public class Category_Product_Dao {
	@Autowired
	private Category_repo category_repo;

	@Autowired
	private Product_repo product_repo;

//getAll
	public List<Category> getAllCategory(int pagenumber, int pagesize) {
		Pageable p = PageRequest.of(pagenumber, pagesize);
		Page<Category> page = category_repo.findAll(p);
		return page.getContent();
	}

//save
	public Category saveCategory(Category category) {
		return category_repo.save(category);
	}

//find by id
	public Optional<Category> getCategoryById(int cid) {
		return category_repo.findById(cid);
	}

// update
	public Category updateCategory(Category category, int cid) {
		Optional<Category> catOptional = category_repo.findById(cid);
		category.setCid(cid);
		return category_repo.save(category);
	}

//delete
	public void deleteCategory(int cid) {
		category_repo.deleteById(cid);
	}

//get all product
	public List<Product> getAllProduct(int pagenumber, int pagesize) {
		Pageable p = PageRequest.of(pagenumber, pagesize);
		Page<Product> page1 = product_repo.findAll(p);
		return page1.getContent();
	}

//save or create
	public Product saveProduct(Product product) {
		return product_repo.save(product);
	}

//find by id
	public Optional<Product> findById(int pid) {
		return product_repo.findById(pid);
	}

//update
	public Product updateproduct(Product product, int pid) {
		Optional<Product> proOptional = product_repo.findById(pid);
		product.setPid(pid);
		return product_repo.save(product);
	}

//delete
	public void deleteProductById(int pid) {
		product_repo.deleteById(pid);
	}

}
