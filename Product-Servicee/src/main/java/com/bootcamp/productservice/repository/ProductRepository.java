package com.bootcamp.productservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.productservice.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	public Optional<Product> findByPname(String pname);
}
