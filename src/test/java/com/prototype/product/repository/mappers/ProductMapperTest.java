package com.prototype.product.repository.mappers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.prototype.product.model.MockObjects;
import com.prototype.product.model.ProductModel;
import com.prototype.product.service.entities.ProductEntity;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProductMapperTest {


    MockObjects mockObjects = new MockObjects();
    @Test
    public void shouldMapEntityToModel() {
       //Arrange
        ProductEntity productEntity = mockObjects.createProductEntity();

        //Act
        ProductModel productModel = ProductMapper.INSTANCE.entityToModel(productEntity);

        //Assert
        assertThat( productModel ).isNotNull();
        assertThat( productModel.getIdProduct() ).isEqualTo( UUID.fromString("d66d8e08-715e-419d-99cd-2fd99b8d7300") );
        assertThat( productModel.getNameProduct()).isEqualTo( "Pañitos Petys" );
        assertThat( productModel.getDescription() ).isEqualTo("Los Pañitos Húmedos Petys con fragancia son ideales para limpiar a tu mascota diariamente, neutralizando los malos olores y dejándola con un agradable aroma");

    }

    @Test
    public void shouldMapEntityToModelNull() {
        //Arrange
        ProductEntity productEntity = null;

        //Act
        ProductModel productModel = ProductMapper.INSTANCE.entityToModel(productEntity);

        //Assert
        assertNull(productModel);

    }

    @Test
    public void shouldMapModelToEntity() {
        //Arrange
        ProductModel productModel = mockObjects.createProductModel();

        //Act
        ProductEntity productEntity = ProductMapper.INSTANCE.modelToEntity(productModel);

        //Asserts
        assertThat( productEntity ).isNotNull();
        assertThat( productEntity.getIdProduct() ).isEqualTo( UUID.fromString("d66d8e08-715e-419d-99cd-2fd99b8d7300") );
        assertThat( productEntity.getNameProduct()).isEqualTo( "Pañitos Petys" );
        assertThat( productEntity.getDescription() ).isEqualTo("Los Pañitos Húmedos Petys con fragancia son ideales para limpiar a tu mascota diariamente, neutralizando los malos olores y dejándola con un agradable aroma");

    }

    @Test
    public void shouldMapModelToEntityNull() {
        //Arrange
        ProductModel productModel = null;

        //Act
        ProductEntity productEntity = ProductMapper.INSTANCE.modelToEntity(productModel);

        //Asserts
        assertNull(productEntity);
    }
      @Test
    public void shouldMapProductsEntitiesToModels(){

        //Arrange
        List<ProductModel> productModelList = new ArrayList<>();
        productModelList.add(mockObjects.createProductModel());
        //Act
        List<ProductEntity> productEntityList = ProductMapper.INSTANCE.productsEntitiesToModels(productModelList);
        //Assert
        assertThat( productEntityList ).isNotNull();
    }
}
