package com.prototype.product.dto.mappers;

import com.prototype.product.dto.ProductRequestUpdateDTO;
import com.prototype.product.dto.ProductResponseDTO;
import com.prototype.product.dto.ProductResquestDTO;
import com.prototype.product.model.MockObjects;
import com.prototype.product.model.MocksDtos;
import com.prototype.product.service.entities.ProductEntity;
import org.junit.Test;


import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ProductMapperDTOTest {

    MocksDtos mocksDtos = new MocksDtos();
    MockObjects mockObjects = new MockObjects();

    @Test
    public void shouldMapProductEntityToProductDto(){

        //Arrange
        ProductEntity  productEntity = mockObjects.createProductEntity();
        //Act
        ProductResponseDTO productResponseDTO = ProductMapperDTO.INSTANCE.productEntityToProductDto(productEntity);
        //Assert
        assertThat( productResponseDTO ).isNotNull();
    }

    @Test
    public void shouldMapProductEntityToProductDtoNull(){

        //Arrange
        ProductEntity  productEntity =null;
        //Act
        ProductResponseDTO productResponseDTO = ProductMapperDTO.INSTANCE.productEntityToProductDto(productEntity);
        //Assert
        assertNull(productResponseDTO);
    }

    @Test
    public void shouldMapProductDtoToProductEntity(){
        //Arrange
        ProductResquestDTO productResquestDTO = mocksDtos.createProductResquestDTO();

        //Act
        ProductEntity  productEntity = ProductMapperDTO.INSTANCE.productDtoToProductEntity(productResquestDTO);

        //Asert
        assertThat( productEntity ).isNotNull();
    }

    @Test
    public void shouldMapProductDtoToProductEntityNull(){
        //Arrange
        ProductResquestDTO productResquestDTO = null;

        //Act
        ProductEntity  productEntity = ProductMapperDTO.INSTANCE.productDtoToProductEntity(productResquestDTO);

        //Asert
        assertNull(productEntity);
    }


    @Test
    public void shouldMapProductUpdateDtoToProductEntity(){
        //Arrange
        ProductRequestUpdateDTO productRequestUpdateDTO = mocksDtos.createProductResquestUpdateDTO();

        //Act
        ProductEntity  productEntity = ProductMapperDTO.INSTANCE.productUpdateDtoToProductEntity(productRequestUpdateDTO);

        //Asert
        assertThat( productEntity ).isNotNull();
    }

    @Test
    public void shouldMapProductUpdateDtoToProductEntityNull(){
        //Arrange
        ProductRequestUpdateDTO productRequestUpdateDTO =null;

        //Act
        ProductEntity  productEntity = ProductMapperDTO.INSTANCE.productUpdateDtoToProductEntity(productRequestUpdateDTO);

        //Asert
        assertNull(productEntity);
    }

    @Test
    public void shouldProductsEntitiesToDtos(){
        //Arrange
        List<ProductEntity> productsEntities = new ArrayList<>();
        productsEntities.add(mockObjects.createProductEntity());

        //Act
        List<ProductResponseDTO> responseDTOList = ProductMapperDTO.INSTANCE.productsEntitiesToDtos(productsEntities);

        //Asert
        assertThat( responseDTOList ).isNotNull();
    }
}
