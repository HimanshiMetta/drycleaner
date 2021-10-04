package com.cg.main.beans;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne(targetEntity = Cart.class, cascade = CascadeType.ALL)
	Cart cart;
	
	@Column
	private LocalDate orderDate = LocalDate.now();
	
	@Column
	private LocalTime orderTime = LocalTime.now();
	
	@OneToOne(targetEntity = Card.class, cascade = CascadeType.ALL)
	Card card;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}
}
