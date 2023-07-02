package com.bootcamp.productservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.productservice.model.Product;
import com.bootcamp.productservice.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository prrepo;
	
	@Override
	public List<Product> findAll() {
		
		return (List<Product>) prrepo.findAll();
	}

	@Override
	public Product findByName(String pname) {
		
		return prrepo.findByPname(pname).orElseThrow(() -> new RuntimeException("Product Not Found!!"));
	}

	@Override
	public Product addProduct(Product product) {
		
		return prrepo.save(product);
	}

	@Override
	public Product updateProduct(int pid, Product product) {
		
	Product existing=prrepo.findById(pid).orElseThrow(() -> new RuntimeException("No Product Avilable with ID ::"+pid));
		
	if(product.getPname()!=null)
		existing.setPname(product.getPname());
	if(product.getPrice()!=null)
		existing.setPrice(product.getPrice());
	if(product.getQuantity()!=null)
		existing.setQuantity(product.getQuantity());
	
	return prrepo.save(existing);
	}

	@Override
	public String deleteProduct(int pid) {
		 Product existing = prrepo.findById(pid).orElseThrow(() -> new RuntimeException("No Product Available with ID !!"+pid));
	prrepo.deleteById(pid);
		 return "Product Deleted";
	}
	

}
