package com.prototype.product.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestUpdateDTO extends ProductResquestDTO{

	
	@ApiParam(value = "Identificador del producto",name = "idProduct", type = "String", example = "8c8a0f04-5c88-463e-ad22-2f4f7e839056")
	@NotNull(message = "El campo idProduct no puede ser nulo")
	@NotBlank(message = "El campo idProduct no puede ser vacio")
	@Pattern(regexp = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$", message = "El parámetro idProduct debe contener un formato válido")
	private String idProduct;
	
	
}
