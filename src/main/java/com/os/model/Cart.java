package com.os.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cartId;
	private Integer product_quantity;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Product> products;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Customer customer;
	
	
	
}
