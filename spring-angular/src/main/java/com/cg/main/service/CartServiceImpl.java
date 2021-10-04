package com.cg.main.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.main.beans.Cart;
import com.cg.main.beans.Product;
import com.cg.main.beans.User;
import com.cg.main.dao.ICartRepository;

@Service
public class CartServiceImpl implements ICartService{
	
	@Autowired
	private ICartRepository icr;

	private Cart cart1 = new Cart();
	
	@Override
	public Cart createCart(User user)
	{
		cart1.setUser(user);
		List<Product> dummyproduct = new ArrayList<Product>();
		cart1.setProducts(dummyproduct);
		cart1 =  icr.saveAndFlush(cart1);
		return cart1;
	}
	
	@Override
	public void deleteCart(Cart cart)
	{
		icr.delete(cart);
		cart1 = new Cart();
	}
	
	@Override
	public Cart updateCart(Product products)
	{
		List<Product> prods = cart1.getProducts();
		if(prods == null)
			prods = new ArrayList<Product>();
		prods.add(products);
		cart1.setProducts(prods);
		cart1.setTotal(cart1.getProducts());
		icr.saveAndFlush(cart1);
		System.out.println(cart1);
		return cart1;
	}
	
	@Override
	public void deleteFromCart(Integer productId)
	{
		List<Product> products = cart1.getProducts();
		List<Product> dummyproduct = new ArrayList<Product>();
		cart1.setProducts(dummyproduct);
		for(Product p : products)
		{
			if(p.getProductId() == productId)
			{
				continue;
			}
			else
			{
				cart1.getProducts().add(p);
			}
		}
		cart1.setTotal(cart1.getProducts());
		icr.saveAndFlush(cart1);
	}
	
	@Override
	public List<Product> getCartByUserId()
	{
		System.out.println(cart1.getProducts());
		return cart1.getProducts();
	}
	
	@Override
	public void getCartByUserForDelete(User user)
	{
		for(Cart c : icr.findAll())
		{
			if(c.getUser().getContactNo().compareToIgnoreCase(user.getContactNo()) == 0)
			{
				icr.delete(c);
			}
		}
	}
	
	@Override
	public List<Cart> getAllCarts()
	{
		return icr.findAll();
	}
	
	@Override
	public Cart setCart()
	{
		Cart final_cart = icr.saveAndFlush(cart1);
		cart1 = new Cart();
		return final_cart;
	}
	
	
}
