package com.cg.main.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.main.beans.Product;

public interface IProductRepository extends JpaRepository<Product,Integer> {
//	  public Product addProduct(Product product);
//	  public Product removeProduct(long id); 
//	  public Product updateProduct(long id, Product product); 
//	  public Product getProduct(long id); 
//	  public List<Product> getAllProduct(); 
	@Query("from Product where lower(productName)=lower(:pname)")
	public List<Product> getProductsByName(@Param("pname") String name);
	
	@Query("from Product where lower(category)=lower(:cat)")
	public List<Product> getProductsByCategory(@Param("cat") String cat);
	
	@Query("from Product order by mrp")
	public List<Product> getProductsByLowToHigh();
	
	@Query("from Product order by mrp desc")
	public List<Product> getProductsByHighToLow();
	
	@Query("from Product where mrp BETWEEN :low AND :high")
	public List<Product> getProductsByPrice(@Param("low") Double low, @Param("high") Double high);
//	  public List<Product> getProductsByName(); 
//	  public List<Product> getProductsBySize();
//	  public List<Product> getProductsByPrice(); 
//	  public List<Product> getProductsByColor();
	 
}