package com.prototype.product.dto;

import java.util.UUID;

import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDTO {

	@ApiParam(value = "Identificador del producto",name = "idProduct", type = "UUID", example = "8c8a0f04-5c88-463e-ad22-2f4f7e839056")
	private UUID idProduct;
	
	@ApiParam(value = "Nombre del producto",name = "mensaje", type = "String", example = "Pañitos humedos Petys")
	private String nameProduct;
	
	@ApiParam(value = "Descipcion del producto",name = "description", type = "String", example = "Los Pañitos Húmedos Petys con fragancia son ideales para limpiar a tu mascota diariamente, neutralizando los malos olores y dejándola con un agradable aroma")
	private String description;
	
	@ApiParam(value = "Cantitdad disponible",name = "quantityAvailable", type = "float", example = "Pañitos humedos")
	private float quantityAvailable; 
	
	@ApiParam(value = "Estado del producto",name = "state", type = "String", example = "Activo")
	private String state;
	
	@ApiParam(value = "Valor Unitario",name = "unitValue", type = "float", example = "204")
	private float unitValue;
	
	@ApiParam(value = "Valor del iva",name = "taxValue", type = "float", example = "180")
	private float taxValue;
	
	@ApiParam(value = "Valos base",name = "baseValue", type = "float", example = "9000")
	private float baseValue;
}
