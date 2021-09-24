package com.prototype.product.controller;

import com.prototype.product.dto.MessageResponse;
import com.prototype.product.dto.ProductRequestUpdateDTO;
import com.prototype.product.dto.ProductResponseDTO;
import com.prototype.product.dto.ProductResquestDTO;
import com.prototype.product.dto.mappers.ProductMapperDTO;
import com.prototype.product.model.MockObjects;
import com.prototype.product.model.MocksDtos;
import com.prototype.product.service.entities.ProductEntity;
import com.prototype.product.service.implement.ProductServiceImplement;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class ProductControllerTest {


    @InjectMocks
    private ProductController productControllerInjectMock;

    @Mock
    private ProductServiceImplement productServiceMock;

    @Mock
    public ProductMapperDTO productMapperDTOMock = ProductMapperDTO.INSTANCE;

    MockObjects mockObjects = new MockObjects();
    MocksDtos mocksDtos =  new MocksDtos();

    @Test
    public void getProducts(){

        //Arrange
        List<ProductEntity> productEntities = new ArrayList<>();
        productEntities.add(mockObjects.createProductEntity());


       Mockito.when(productServiceMock.getProducts())
                .thenReturn(productEntities);

       List<ProductResponseDTO> productResponseDTOS = new ArrayList<>();
       productResponseDTOS.add(mocksDtos.createProductResponseDTO());
       Mockito.when(productMapperDTOMock.productsEntitiesToDtos(productEntities)).thenReturn(productResponseDTOS);

        //Act
        List<ProductResponseDTO> responseDTOListExpect = productControllerInjectMock.getProducts();
        //Assert
        assertNotNull(responseDTOListExpect);
        assertArrayEquals(responseDTOListExpect.toArray(), productResponseDTOS.toArray());
    }


    @Test
    public void getProduct(){

        //Arrange
        String idProduct = "61ae240c-66af-47c9-b36c-2029adcb8a47";

        Mockito.when(productServiceMock.getProduct(UUID.fromString(idProduct)))
                .thenReturn(mockObjects.createProductEntity());

        Mockito.when(productMapperDTOMock.productEntityToProductDto(mockObjects.createProductEntity())).thenReturn(mocksDtos.createProductResponseDTO());

        //Act
        ProductResponseDTO productResponseDTOExpect = productControllerInjectMock.getProduct(idProduct);
        //Assert
        assertNotNull(productResponseDTOExpect);

    }

    @Test
    public void createProduct(){
        //Arrange
       ProductResquestDTO productResquestDTO=  mocksDtos.createProductResquestDTO();

       ProductEntity productEntityMapper = productMapperDTOMock.productDtoToProductEntity(productResquestDTO);

        Mockito.when(productServiceMock.createProduct(productEntityMapper))
                .thenReturn(mocksDtos.createMessageResponse());

        //Act
        MessageResponse messageResponse = productControllerInjectMock.createProduct(productResquestDTO);

        //Assert
        assertNotNull(messageResponse.getMensaje());
    }


    @Test
    public void updateProduct(){
        //Arrange
        ProductRequestUpdateDTO productRequestUpdateDTO=  mocksDtos.createProductResquestUpdateDTO();

        ProductEntity productEntityMapper = productMapperDTOMock.productUpdateDtoToProductEntity(productRequestUpdateDTO);

        Mockito.when(productServiceMock.updateProduct(productEntityMapper))
                .thenReturn(mocksDtos.createMessageResponse());

        //Act
        MessageResponse messageResponse = productControllerInjectMock.updateProduct(productRequestUpdateDTO);

        //Assert
        assertNotNull(messageResponse.getMensaje());
    }

    @Test
    public void deleteProduct(){

        //Arrange
        String idProduct = "61ae240c-66af-47c9-b36c-2029adcb8a47";

        Mockito.when(productServiceMock.deleteProduct(UUID.fromString(idProduct)))
                .thenReturn(mocksDtos.createMessageResponse());
        //Act
        MessageResponse messageResponse = productControllerInjectMock.deleteProduct(idProduct);

        //Assert
        assertNotNull(messageResponse.getMensaje());

    }
}
