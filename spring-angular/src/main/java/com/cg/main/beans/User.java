package com.cg.main.beans;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "password")
	private String password;
	
	@Column(name = "contactNo")
	private String contactNo;
	
	@Column(name = "emailId")
	private String emailId;
	
	@Column(name = "address")
	private String address;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ",\n name=" + name + ",\n password=" + password + ",\n contactNo=" + contactNo
				+ ",\n emailId=" + emailId + ",\n address=" + address + "]";
	}
	
	//Insert into user(id, name, password, address, contact_no, email_id) values (1,'drycleaner','12drycleaner34', 'Shop No 14/A, Sector 7, Bangalore', '9340227709', 'thedrycleaner@outlook.com');

}