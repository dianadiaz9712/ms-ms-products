package com.prototype.product.dto;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResquestDTO {

	@ApiParam(value = "Nombre del producto",name = "mensaje", type = "String", example = "Pañitos humedos Petys")
	@NotNull(message = "El campo nameProduct no puede ser nulo")
	@NotBlank(message = "El campo nameProduct no puede ser vacio")
	private String nameProduct;
	
	@ApiParam(value = "Descipcion del producto",name = "description", type = "String", example = "Los Pañitos Húmedos Petys con fragancia son ideales para limpiar a tu mascota diariamente, neutralizando los malos olores y dejándola con un agradable aroma")
	private String description;
	
	@ApiParam(value = "Cantitdad disponible",name = "quantityAvailable", type = "float", example = "50")
	@NotNull(message = "El campo quantityAvailable no puede ser nulo")
	private int quantityAvailable; 
	
	@ApiParam(value = "Estado del producto",name = "state", type = "String", example = "Activo")
	@NotNull(message = "El campo state no puede ser nulo")
	@NotBlank(message = "El campo state no puede ser vacio")
	private String state;
	
	
	@ApiParam(value = "Valor Unitario",name = "unitValue", type = "float", example = "204")
	@NotNull(message = "El campo unitValue no puede ser nulo")
	@Digits(integer = 100 /*precision*/, fraction = 2 /*scale*/)
    @DecimalMin(value = "0.1", inclusive = false, message = "El campo unitValue debe ser mayor que 0")
	private float unitValue;
	
	@ApiParam(value = "Valor del iva",name = "taxValue", type = "float", example = "180")
	@NotNull(message = "El campo taxValue no puede ser nulo")
	@Digits(integer = 100 /*precision*/, fraction = 2 /*scale*/)
	@DecimalMin(value = "0.0", inclusive = false, message = "El campo taxValue debe ser mayor o igual que 0")
	private float taxValue;
	
	@ApiParam(value = "Valos base",name = "baseValue", type = "float", example = "9000")
	@NotNull(message = "El campo baseValue no puede ser nulo")
	@Digits(integer = 100 /*precision*/, fraction = 2 /*scale*/)
	@DecimalMin(value = "0.1", inclusive = false , message = "El campo baseValue debe ser mayor que 0")
	private float baseValue;
}
