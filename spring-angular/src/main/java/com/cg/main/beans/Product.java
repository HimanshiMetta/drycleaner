package com.cg.main.beans;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Table
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer productId;
		
	@Column
	@NotEmpty(message="Category name should not be empty")
	private String category;
	
	@Column
	@NotEmpty(message="Description should not be empty")
	private String description;
	
	@Column
	//@NotEmpty(message="Quantity should not be empty")
	private Integer quantity;
	
	@Column
	@NotEmpty(message="Material should not be empty")
	private String material;
	
	@Column
	private Integer price;
//--------------------------------------------------------------------------------------------------------------------

	public Product() {
		super();
	}

	public Product(Integer productId,
			@NotEmpty(message = "Category name should not be empty") String category,
			@NotEmpty(message = "Product name should not be empty") String description,
			@NotEmpty(message = "Description name should not be empty") Integer quantity,
			@NotEmpty(message = "Brand name should not be empty") String material) {
		super();
		this.productId = productId;
		this.category = category;
		this.description = description;
		this.quantity = quantity;
		this.material = material;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public Integer getPrice() {
		return price;
	}
	
	public void setPrice(Integer price)
	{
		this.price = price;
	}

	public void setPrice() {
		switch(this.category)
        {
        case "Shirt" : this.price=10*this.quantity;              break;
        case "Saree-Silk" : this.price=49*this.quantity;         break;
        case "Designer" : this.price=79*this.quantity;         break;
        case "Gents-Kurta" : this.price=8*this.quantity;         break;
        case "Ladies-Kurta" : this.price=8*this.quantity;         break;
        case "Blazer-jacket" : this.price=10*this.quantity;    break;
        case "Bedsheet-Double" : this.price=29*this.quantity;  break;
        case "Pant" : this.price=12*this.quantity;             break;
        default: this.price=50*this.quantity;
        }
	}

	@Override
	public String toString() {
		return "\nProduct [productId=" + productId + ", category=" + category + ", description=" + description
				+ ", quantity=" + quantity + ", material=" + material + ", price=" + price + "]\n";
	}
		
}