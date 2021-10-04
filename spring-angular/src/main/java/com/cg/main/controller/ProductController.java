package com.cg.main.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.main.beans.Product;
import com.cg.main.service.CartServiceImpl;
import com.cg.main.service.IProductService;



@RestController
@RequestMapping("/product")
@CrossOrigin(origins="http://localhost:4200")
public class ProductController {
	@Autowired
	private IProductService productService;

	@Autowired
	public CartServiceImpl csi;

	//add product
	@PostMapping("/add")
	public Product addProduct(@Valid @RequestBody Product product) { 
		Product newp = productService.addProduct(product);
		csi.updateCart(newp);
		return newp;
	}
	
	//delete product
	@DeleteMapping("/delete/{id}")
	public Map<String,Boolean> removeProduct(@PathVariable(value="id") Integer id) 
	{
		csi.deleteFromCart(id);
		productService.removeProduct(id);
		Map<String,Boolean> response = new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		return response;		
	}
	
	//update product
	@PutMapping("/update/{id}")
	public Product updateProduct(@PathVariable(value="id") Integer id,@Valid @RequestBody Product product) 
	{
		csi.deleteFromCart(id);
		Product updatedProduct=productService.updateProduct(id,product);
		csi.updateCart(updatedProduct);
		return updatedProduct;
	}
	
	//Get Product by Id
	@GetMapping("/id/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable(value="id") Integer id)
	{
		Product product = productService.getProduct(id);
		return ResponseEntity.ok().body(product);
	}
	
	//Get List of all Products
	@GetMapping("/all")
	public List<Product> getAllProduct()
	{
		return csi.getCartByUserId();
		//return productService.getAllProduct();
	}
	
	//Get List of all Products by name
	@GetMapping("/name/{name}")
	public List<Product> getProductsByName(@PathVariable(value="name") String name) 
	{
		return productService.getProductsByName(name);
	}
	
	//Get List of all Products by category
	@GetMapping("/category/{category}")
	public List<Product> getProductsByCategory(@PathVariable(value="category") String cat) 
	{
		return productService.getProductsByCategory(cat);
	}

	//Get List of all Products by low to high
	@GetMapping("/low")
	public List<Product> getProductsByLowToHigh() 
	{
		return productService.getProductsByLowToHigh();
	}
	
	//Get List of all Products by high to low 
	@GetMapping("/high")
	public List<Product> getProductsByHighToLow() 
	{
		return productService.getProductsByHighToLow();
	}
	
	//Get List of all Products by low to high
		@GetMapping("/price/{low}/{high}")
		public List<Product> getProductsByPrice(@PathVariable(value="low") Double low, @PathVariable(value="high") Double high) 
		{
			return productService.getProductsByPrice(low, high);
		}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	
	public Map<String,String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex)
	{
		Map<String,String> errors=new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error->errors.put(error.getField(), error.getDefaultMessage()));
        return errors;
	}
}