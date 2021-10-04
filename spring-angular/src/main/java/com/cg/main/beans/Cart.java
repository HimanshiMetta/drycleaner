package com.cg.main.beans;

import java.util.List;

import javax.persistence.*;

@Entity
public class Cart {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne(targetEntity = User.class, cascade = CascadeType.ALL)
	User user;
	
	@OneToMany
	@JoinColumn
	private List<Product> products;
	
	@Column
	private Integer total;
	
	public Cart(){}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(List<Product> products) {
		Integer sum = 0;
		for(Product p : products)
		{
			sum += p.getPrice();
		}
		this.total = sum;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ",\n user=" + user + ",\n products=" + products + ",\n total=" + total + "]";
	}	
}
