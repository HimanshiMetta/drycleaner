package com.cg.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.main.beans.Product;
import com.cg.main.dao.IProductRepository;
import com.cg.main.exception.ProductNotFoundException;



@Service
public class ProductServiceImpl implements IProductService{
	
	@Autowired
	private IProductRepository productRepository;

	@Override
	public Product addProduct(Product product) {
		// TODO Auto-generated method stub
		product.setPrice();
		return productRepository.saveAndFlush(product);
	}

	@Override
	public void removeProduct(Integer id) {
		// TODO Auto-generated method stub
		productRepository.deleteById(id);
	}

	@Override
	public Product updateProduct(Integer id, Product product) {
		// TODO Auto-generated method stub
		Product p=null;
		try {
			p=productRepository.findById(id).orElseThrow(()-> new ProductNotFoundException("No product found with this id: "+id));
		}
		catch(ProductNotFoundException e) {
			e.printStackTrace();
		}
		p.setCategory(product.getCategory());
		p.setQuantity(product.getQuantity());
		p.setDescription(product.getDescription());
		p.setMaterial(product.getMaterial());
		//product.setPrice();
		p.setPrice();
	    return productRepository.save(p);	  
	}

	@Override
	public Product getProduct(Integer id) {
		// TODO Auto-generated method stub
		Product p=null;
		p=productRepository.findById(id).get();
		return p;
	}

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}
	
	@Override
	public List<Product> getProductsByName(String name) {
		// TODO Auto-generated method stub
		return productRepository.getProductsByName(name);
	}

	@Override
	public List<Product> getProductsByCategory(String cat) {
		// TODO Auto-generated method stub
		return productRepository.getProductsByCategory(cat);
	}
	
	@Override
	public List<Product> getProductsByLowToHigh() {
		// TODO Auto-generated method stub
		return productRepository.getProductsByLowToHigh();
	}

	@Override
	public List<Product> getProductsByHighToLow() {
		// TODO Auto-generated method stub
		return productRepository.getProductsByHighToLow();
	}

	@Override
	public List<Product> getProductsByPrice(Double low, Double high) {
		// TODO Auto-generated method stub
		return productRepository.getProductsByPrice(low, high);
	}

}