package com.cg.main.service;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;

import com.cg.main.beans.Product;

public interface IProductService {
	public Product addProduct(Product product);
	public void removeProduct(Integer id);
	public Product updateProduct(Integer id, Product product);
	public Product getProduct(Integer id);
	public List<Product> getAllProduct();
	public List<Product> getProductsByName(String name);
	public List<Product> getProductsByCategory(String cat);
	public List<Product> getProductsByLowToHigh();
	public List<Product> getProductsByHighToLow();
	public List<Product> getProductsByPrice(Double low, Double high);
//	public List<Product> getProductsBySize();
//	public List<Product> getProductsByPrice();
//	public List<Product> getProductsByColor();
}