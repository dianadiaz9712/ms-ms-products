package com.prototype.product.dto;

import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageResponse {

	@ApiParam(value = "Mensaje de respuesta",name = "mensaje", type = "String", example = "Se ha actualizado el producto")
	private String mensaje;
}
