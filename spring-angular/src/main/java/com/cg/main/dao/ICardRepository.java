package com.cg.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.main.beans.Card;

public interface ICardRepository extends JpaRepository<Card,Integer>{
}
