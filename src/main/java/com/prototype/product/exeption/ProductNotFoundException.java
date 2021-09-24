package com.prototype.product.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( value = HttpStatus.NO_CONTENT)
public class ProductNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -2675180781575463758L;

	public ProductNotFoundException(String message) {
		super(message);
	}

}
