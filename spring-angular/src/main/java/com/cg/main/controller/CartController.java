package com.cg.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.cg.main.beans.Cart;
import com.cg.main.beans.Product;
import com.cg.main.beans.User;
import com.cg.main.service.CartServiceImpl;

@RestController
public class CartController {
	
	Cart presentCart = new Cart();

	public CartServiceImpl csi = new CartServiceImpl();
	
	public void updatePresentCart(User user)
	{
		csi.createCart(user);
	}
	
	public void updatePresentCartProduct(Product products)
	{
		csi.updateCart(products);
	}
	
	public void getAllProductsInPresentCart()
	{
		System.out.println(presentCart.getProducts());
	}
	
	public void deletePresentCart()
	{
		csi.deleteCart(presentCart);
		presentCart = null;
	}
	
	public void deleteCartsOfUser(User user)
	{
		csi.getCartByUserForDelete(user);
	}
}
