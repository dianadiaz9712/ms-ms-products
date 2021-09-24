package com.prototype.product.service.implement;

import com.prototype.product.constant.ProductConstant;
import com.prototype.product.dto.MessageResponse;
import com.prototype.product.exeption.ProductConflictException;
import com.prototype.product.exeption.ProductNotFoundException;
import com.prototype.product.model.MockObjects;
import com.prototype.product.model.ProductModel;
import com.prototype.product.repository.ProductRepository;
import com.prototype.product.repository.mappers.ProductMapper;
import com.prototype.product.service.entities.ProductEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplementTest {
    @InjectMocks
    private ProductServiceImplement productServiceImplementInjectMock;

    @Mock
    private ProductRepository productRepositoryMock;

    @Mock
    public ProductMapper productMapperMock = ProductMapper.INSTANCE ;

    MockObjects mockObjects = new MockObjects();

    @Test
    public void getProducts(){
        //Arrange
        List<ProductModel> listProductModel = new ArrayList<>();
        listProductModel.add(mockObjects.createProductModel());

        Mockito.when(productRepositoryMock.findByState(ProductConstant.ACTIVO)).thenReturn(listProductModel);

        List<ProductEntity> productEntityList = new ArrayList<>();
        productEntityList.add(mockObjects.createProductEntity());

        Mockito.when(productMapperMock.productsEntitiesToModels(listProductModel)).thenReturn(productEntityList);

        //Act
        List<ProductEntity> productEntityListExpect = productServiceImplementInjectMock.getProducts();

        //Assert
        assertNotNull(productEntityListExpect);

    }
    @Test(expected = ProductNotFoundException.class)
    public void getProductsError(){
        //Arrange
        List<ProductModel> listProductModel = new ArrayList<>();
        Mockito.when(productRepositoryMock.findByState(ProductConstant.ACTIVO)).thenReturn(listProductModel);

        //Act
      productServiceImplementInjectMock.getProducts();

    }

    @Test
    public void getProduct(){
        //Arrange
        UUID idProduct = UUID.fromString("61ae240c-66af-47c9-b36c-2029adcb8a47");
       ProductModel productModel = mockObjects.createProductModel();

        Mockito.when(productRepositoryMock.findById(idProduct)).thenReturn(Optional.of(productModel));

        Mockito.when(productMapperMock.modelToEntity(productModel)).thenReturn(mockObjects.createProductEntity());

        //Act
        ProductEntity productEntity= productServiceImplementInjectMock.getProduct(idProduct);

        //Assert
        assertNotNull(productEntity);

    }

    @Test(expected = ProductNotFoundException.class)
    public void getProductError(){
        //Arrange
        UUID idProduct = UUID.fromString("61ae240c-66af-47c9-b36c-2029adcb8a47");

        Mockito.when(productRepositoryMock.findById(idProduct)).thenReturn(Optional.empty());

        //Act
      productServiceImplementInjectMock.getProduct(idProduct);


    }


    @Test
    public void createProduct(){
        //Arrange
        ProductModel productModel = mockObjects.createProductModel();

        Mockito.when(productMapperMock.entityToModel(mockObjects.createProductEntity())).thenReturn(productModel);
        //Act
        MessageResponse messageResponse= productServiceImplementInjectMock.createProduct(mockObjects.createProductEntity());

        //Assert
        assertNotNull(messageResponse.getMensaje());


    }

    @Test(expected = ProductConflictException.class)
    public void createProductError(){
        //Arrange
        ProductModel productModel = mockObjects.createProductModel();

        Mockito.when(productMapperMock.entityToModel(mockObjects.createProductEntity())).thenReturn(productModel);
        Mockito.when(productRepositoryMock.findByNameProductAndState(productModel.getNameProduct(), ProductConstant.ACTIVO)).thenReturn(Optional.of(productModel));

        //Act
        productServiceImplementInjectMock.createProduct(mockObjects.createProductEntity());


    }


    @Test
    public void updateProduct(){
        //Arrange
        ProductModel productModel = mockObjects.createProductModel();

        Mockito.when(productRepositoryMock.findById(productModel.getIdProduct())).thenReturn(Optional.of(productModel));

        Mockito.when(productMapperMock.entityToModel(mockObjects.createProductEntity())).thenReturn(productModel);
        //Act
        MessageResponse messageResponse= productServiceImplementInjectMock.updateProduct(mockObjects.createProductEntity());

        //Assert
        assertNotNull(messageResponse.getMensaje());

    }

    @Test(expected = ProductNotFoundException.class)
    public void updateProductError(){
        //Arrange
        ProductModel productModel = mockObjects.createProductModel();

        Mockito.when(productMapperMock.entityToModel(mockObjects.createProductEntity())).thenReturn(productModel);

        Mockito.when(productRepositoryMock.findById(productModel.getIdProduct())).thenReturn(Optional.empty());

        //Act
        productServiceImplementInjectMock.updateProduct(mockObjects.createProductEntity());

    }
    @Test
    public void deleteProduct(){
        //Arrange
        UUID idProduct = UUID.fromString("61ae240c-66af-47c9-b36c-2029adcb8a47");

        ProductModel productModel = mockObjects.createProductModel();

        Mockito.when(productRepositoryMock.findById(idProduct)).thenReturn(Optional.of(productModel));

        //Act
        MessageResponse messageResponse= productServiceImplementInjectMock.deleteProduct(idProduct);

        //Assert
        assertNotNull(messageResponse.getMensaje());

    }

    @Test(expected = ProductNotFoundException.class)
    public void deleteProductError(){
        //Arrange
        UUID idProduct = UUID.fromString("61ae240c-66af-47c9-b36c-2029adcb8a47");


        Mockito.when(productRepositoryMock.findById(idProduct)).thenReturn(Optional.empty());

        //Act
        productServiceImplementInjectMock.deleteProduct(idProduct);

    }
}
