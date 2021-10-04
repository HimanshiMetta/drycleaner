package com.cg.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.main.beans.Cart;

public interface ICartRepository extends JpaRepository<Cart,Integer>{

}
