package com.cg.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.main.beans.Order;

public interface IOrderRepository extends JpaRepository<Order,Integer>{
}
