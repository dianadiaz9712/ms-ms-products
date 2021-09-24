package com.prototype.product.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import com.prototype.product.model.ProductModel;

public interface ProductRepository extends JpaRepository<ProductModel, UUID>{

	 List<ProductModel> findByState(String state);
	
	 Optional<ProductModel> findByNameProductAndState(String nameProduct, String state);
}
