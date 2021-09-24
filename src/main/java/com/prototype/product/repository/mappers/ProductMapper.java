package com.prototype.product.repository.mappers;

import java.util.List;

import com.prototype.product.service.entities.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.prototype.product.model.ProductModel;

@Mapper(componentModel = "spring")
public interface ProductMapper {
	
	ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);


	ProductEntity modelToEntity(ProductModel productModel);
	
	ProductModel entityToModel(ProductEntity productEntity);
	
	List<ProductEntity> productsEntitiesToModels(final List<ProductModel> productsModels);
}