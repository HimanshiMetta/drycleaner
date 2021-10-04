package com.cg.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.main.beans.Card;
import com.cg.main.beans.Order;
import com.cg.main.dao.IOrderRepository;

@Service
public class OrderServiceImpl implements IOrderService{

	@Autowired
	IOrderRepository ior;
	
	@Autowired
	public CartServiceImpl csi;
	
	private Order order1 = new Order();
	
	@Override
	public Order setOrder(Card card) {
		order1.setCard(card);
		order1.setCart(csi.setCart());
		Order order2 = ior.saveAndFlush(order1);
		order1 = new Order();
		return order2;
	}
	
}
