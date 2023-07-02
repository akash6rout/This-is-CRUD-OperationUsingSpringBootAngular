package com.bootcamp.productservice.service;

import java.util.List;

import com.bootcamp.productservice.model.Product;

public interface ProductService {

	public List<Product> findAll();
	
	public Product findByName(String pname);
	
	public Product addProduct(Product product);
	
	public Product updateProduct(int id,Product product);
	
	public String deleteProduct(int pid);
}
