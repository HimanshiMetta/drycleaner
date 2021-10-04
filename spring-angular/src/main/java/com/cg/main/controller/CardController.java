package com.cg.main.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.main.beans.Card;
import com.cg.main.beans.User;
import com.cg.main.dao.ICardRepository;
import com.cg.main.service.OrderServiceImpl;

@RestController
@RequestMapping(path = "card")
@CrossOrigin(origins="http://localhost:4200")
public class CardController {
	
	@Autowired
	public ICardRepository icardr;
	
	@Autowired
	public OrderServiceImpl osi;
	
	Card card1 = new Card();
	
	@PostMapping("/add")
	public Card addCard(@Valid @RequestBody Card card) {
		
		card1 = icardr.save(card);
		osi.setOrder(card1);
		return card1;
//		presentUser = iur.save(user);
//		csi.createCart(user);
//		return presentUser;
	}

}
