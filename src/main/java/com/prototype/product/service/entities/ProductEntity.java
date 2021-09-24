package com.prototype.product.service.entities;

import java.util.UUID;

import lombok.Data;


@Data
public class ProductEntity {

    private UUID idProduct;
	
	private String nameProduct;
	
	private String description;
	
	private int quantityAvailable; 
	
	private String state;
	
	private float unitValue;
	
	private float taxValue;
	
	private float baseValue;
}
