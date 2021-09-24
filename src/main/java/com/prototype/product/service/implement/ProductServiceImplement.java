package com.prototype.product.service.implement;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.prototype.product.service.entities.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prototype.product.constant.ProductConstant;
import com.prototype.product.constant.ProductMessages;
import com.prototype.product.dto.MessageResponse;
import com.prototype.product.exeption.ProductNotFoundException;
import com.prototype.product.exeption.ProductConflictException;
import com.prototype.product.model.ProductModel;
import com.prototype.product.repository.ProductRepository;
import com.prototype.product.repository.mappers.ProductMapper;
import com.prototype.product.service.ProductService;

/**
 * @author dianadiazmartinez
 *
 */

@Service
public class ProductServiceImplement implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	ProductMapper productMapper;

	/**
	 *
	 * Method for consulting available productss
	 *
	 */
	@Override
	public List<ProductEntity> getProducts() {
		List<ProductModel> listProductModel = productRepository.findByState(ProductConstant.ACTIVO);
		if (listProductModel.isEmpty()) {
			throw new ProductNotFoundException(ProductMessages.DESCP0001);
		} else {
			return productMapper.productsEntitiesToModels(listProductModel);
		}
	}

	/*
	 * Method for consulting by product id
	 */

	@Override
	public ProductEntity getProduct(UUID idProduct) {
		Optional<ProductModel> optProduct = productRepository.findById(idProduct);
		if (optProduct.isPresent()) {
			return productMapper.modelToEntity(optProduct.get());
		} else {
			throw new ProductNotFoundException(ProductMessages.DESCP0002);
		}
	}

	/**
	 *
	 * Method for creating products
	 *
	 */
	@Override
	public MessageResponse createProduct(ProductEntity productEntity) {
		MessageResponse mes = new MessageResponse();

		ProductModel productModel = productMapper.entityToModel(productEntity);

		Optional<ProductModel> optProductModel = productRepository
				.findByNameProductAndState(productModel.getNameProduct(), ProductConstant.ACTIVO);

		if (optProductModel.isPresent()) {
			throw new ProductConflictException(ProductMessages.DESCP0008);
		} else {
			productModel.setState(ProductConstant.ACTIVO);
			productRepository.save(productModel);
			mes.setMensaje(ProductMessages.DESCP0003);
		}

		return mes;

	}

	/**
	 *
	 * Method for update products
	 *
	 */
	@Override
	public MessageResponse updateProduct(ProductEntity productEntity) {
		MessageResponse mes = new MessageResponse();
			ProductModel productModel = productMapper.entityToModel(productEntity);
			Optional<ProductModel> optProductModel = productRepository.findById(productModel.getIdProduct());

			if (optProductModel.isPresent()) {
				productRepository.save(productModel);
				mes.setMensaje(ProductMessages.DESCP0004);
			} else {
				throw new ProductNotFoundException(ProductMessages.DESCP0005);
			}

			return mes;
	}

	/**
	 *
	 * Method for update products
	 *
	 */
	@Override
	public MessageResponse deleteProduct(UUID idProduct) {
		MessageResponse mes = new MessageResponse();
		Optional<ProductModel> optProductModel = productRepository.findById(idProduct);

		if (optProductModel.isPresent()) {
			ProductModel productModel = optProductModel.get();
			productModel.setState(ProductConstant.INACTIVO);
			productRepository.save(productModel);
			mes.setMensaje(ProductMessages.DESCP0006);
		} else {
			throw new ProductNotFoundException(ProductMessages.DESCP0007);
		}
		return mes;
	}
}
