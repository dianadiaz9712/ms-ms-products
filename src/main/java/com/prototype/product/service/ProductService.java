package com.prototype.product.service;

import java.util.List;
import java.util.UUID;

import com.prototype.product.dto.MessageResponse;
import com.prototype.product.service.entities.ProductEntity;

public interface ProductService {
	
	 List<ProductEntity> getProducts();
	
	 ProductEntity getProduct(UUID idProduct);
	
	 MessageResponse createProduct(ProductEntity productEntity);
	
	 MessageResponse updateProduct(ProductEntity productEntity);
	
	 MessageResponse deleteProduct(UUID idProduct);
}
