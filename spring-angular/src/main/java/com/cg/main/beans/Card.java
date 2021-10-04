package com.cg.main.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Card {
	@Id
	@Column(name = "cardId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cardId;

	@Column(name = "bankName")
	private String bankName;

	@Column(name = "cardNumber")
	private String cardNumber;
	
	@Column(name = "expiryDate")
	private String expiryDate;
	
	@Column(name = "cvv")
	private String cvv;
	
	public Card() {}

	public Integer getId() {
		return cardId;
	}

	public void setId(Integer cardId) {
		this.cardId = cardId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber.substring(0, 5)+"********"+cardNumber.substring(13);
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = "***";
	}

	@Override
	public String toString() {
		return "Card [id=" + cardId + ",\n BankName=" + bankName + ",\n cardNumber=" + cardNumber + ",\n expiryDate=" + expiryDate
				+ ",\n cvv=" + cvv + "]";
	}

	
}
