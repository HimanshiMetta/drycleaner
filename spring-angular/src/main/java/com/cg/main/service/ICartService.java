package com.cg.main.service;

import java.util.List;

import com.cg.main.beans.Cart;
import com.cg.main.beans.Product;
import com.cg.main.beans.User;

public interface ICartService {
	public Cart createCart(User user);
	public void deleteCart(Cart cart);
	public void deleteFromCart(Integer productId);
	public Cart updateCart(Product products);
	public List<Product> getCartByUserId();
	public void getCartByUserForDelete(User user);
	public List<Cart> getAllCarts();
	public Cart setCart();
}
