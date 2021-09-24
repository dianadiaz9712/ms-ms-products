package com.prototype.product.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="product")
@Getter
@Setter
public class ProductModel extends Auditable {

	@Id
	@GeneratedValue
	private UUID idProduct;
	
	@Column(name = "nameproduct")
	private String nameProduct;
	
	@Column(name = "description" )
	private String description;
	
	@Column(name = "quantityavaliable")
	private int quantityAvailable; 
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "unitvalue")
	private float unitValue;
	
	@Column(name = "taxvalue")
	private float taxValue;
	
	@Column(name = "basevalue")
	private float baseValue;
	
	

}
