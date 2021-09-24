package com.prototype.product.model;

import com.prototype.product.service.entities.ProductEntity;

import java.util.UUID;

public class MockObjects {

    public ProductEntity createProductEntity(){
        ProductEntity productEntity = new ProductEntity();
        productEntity.setIdProduct(UUID.fromString("d66d8e08-715e-419d-99cd-2fd99b8d7300"));
        productEntity.setNameProduct("Pañitos Petys");
        productEntity.setDescription("Los Pañitos Húmedos Petys con fragancia son ideales para limpiar a tu mascota diariamente, neutralizando los malos olores y dejándola con un agradable aroma");
        productEntity.setQuantityAvailable(50);
        productEntity.setState("Activo");
        productEntity.setUnitValue(204.0f);
        productEntity.setTaxValue(908.0f);
        productEntity.setBaseValue(9000.0f);
        return productEntity;
    }

    public ProductModel createProductModel(){
        ProductModel productModel = new ProductModel();
        productModel.setIdProduct(UUID.fromString("d66d8e08-715e-419d-99cd-2fd99b8d7300"));
        productModel.setNameProduct("Pañitos Petys");
        productModel.setDescription("Los Pañitos Húmedos Petys con fragancia son ideales para limpiar a tu mascota diariamente, neutralizando los malos olores y dejándola con un agradable aroma");
        productModel.setQuantityAvailable(50);
        productModel.setState("Activo");
        productModel.setUnitValue(204.0f);
        productModel.setTaxValue(908.0f);
        productModel.setBaseValue(9000.0f);
        return productModel;
    }
}
