package com.ty.Category_Product.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.Category_Product.dao.Category_Product_Dao;
import com.ty.Category_Product.dto.Category;
import com.ty.Category_Product.dto.Product;

@RestController
public class Controller {
	@Autowired
	private Category_Product_Dao dao;

//get all
	@GetMapping("api/categories/page")
	public List<Category> getAllCategory(
			@RequestParam(value = "pagenumber", defaultValue = "0", required = false) Integer pagenumber,
			@RequestParam(value = "pagesize", defaultValue = "2", required = false) Integer pagesize) {
		return dao.getAllCategory(pagenumber, pagesize);
	}

//create
	@PostMapping("api/categories")
	public Category saveCatogery(@RequestBody Category category) {
		return dao.saveCategory(category);
	}

//get by id
	@GetMapping("api/categories/{di}")
	public Optional<Category> getById(@PathVariable("di") int id) {
		return dao.getCategoryById(id);
	}

//update by id
	@PutMapping("api/categories/{di}")
	public Category updateCategory(@RequestBody Category category, @PathVariable("di") int id) {
		return dao.updateCategory(category, id);
	}

//delete by id
	@DeleteMapping("api/categories/{di}")
	public void deleteById(@PathVariable("di") int id) {
		dao.deleteCategory(id);
	}

//get all
	@GetMapping("api/products/page")
	public List<Product> getAllProduct(
			@RequestParam(value = "pagenumber", defaultValue = "0", required = false) Integer pagenumber,
			@RequestParam(value = "pagesize", defaultValue = "2", required = false) Integer pagesize) {
		return dao.getAllProduct(pagenumber, pagesize);
	}

//create
	@PostMapping("api/products")
	public Product saveProduct(@RequestBody Product product) {
		return dao.saveProduct(product);
	}
	//

//get by id
	@GetMapping("api/products/{di}")
	public Optional<Product> getProductById(@PathVariable("di") int id) {
		return dao.findById(id);
	}

//update by id
	@PutMapping("api/products/{di}")
	public Product updateProduct(@RequestBody Product products, @PathVariable("di") int id) {
		return dao.updateproduct(products, id);

	}

//delete by id
	@DeleteMapping("api/products/{di}")
	public void deleteProductById(@PathVariable int id) {
		dao.deleteProductById(id);
	}

}
