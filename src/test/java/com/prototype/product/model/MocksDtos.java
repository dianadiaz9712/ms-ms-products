package com.prototype.product.model;

import com.prototype.product.dto.MessageResponse;
import com.prototype.product.dto.ProductRequestUpdateDTO;
import com.prototype.product.dto.ProductResponseDTO;
import com.prototype.product.dto.ProductResquestDTO;

import java.util.UUID;

public class MocksDtos {

    public ProductResponseDTO createProductResponseDTO(){
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setIdProduct(UUID.fromString("d66d8e08-715e-419d-99cd-2fd99b8d7300"));
        productResponseDTO.setNameProduct("Pañitos Petys");
        productResponseDTO.setDescription("Los Pañitos Húmedos Petys con fragancia son ideales para limpiar a tu mascota diariamente, neutralizando los malos olores y dejándola con un agradable aroma");
        productResponseDTO.setQuantityAvailable(50);
        productResponseDTO.setState("Activo");
        productResponseDTO.setUnitValue(204.0f);
        productResponseDTO.setTaxValue(908.0f);
        productResponseDTO.setBaseValue(9000.0f);
        return productResponseDTO;

    }

    public ProductResquestDTO createProductResquestDTO(){
        ProductResquestDTO productResquestDTO = new ProductResquestDTO();
        productResquestDTO.setNameProduct("Pañitos Petys");
        productResquestDTO.setDescription("Los Pañitos Húmedos Petys con fragancia son ideales para limpiar a tu mascota diariamente, neutralizando los malos olores y dejándola con un agradable aroma");
        productResquestDTO.setQuantityAvailable(50);
        productResquestDTO.setUnitValue(204.0f);
        productResquestDTO.setTaxValue(908.0f);
        productResquestDTO.setBaseValue(9000.0f);
        return productResquestDTO;
    }

    public MessageResponse createMessageResponse(){
        MessageResponse messageResponse = new MessageResponse();
        messageResponse.setMensaje("Exito");
        return messageResponse;
    }

    public ProductRequestUpdateDTO createProductResquestUpdateDTO(){
        ProductRequestUpdateDTO productRequestUpdateDTO = new ProductRequestUpdateDTO();
        productRequestUpdateDTO.setIdProduct("61ae240c-66af-47c9-b36c-2029adcb8a4");
        productRequestUpdateDTO.setNameProduct("Pañitos Petys");
        productRequestUpdateDTO.setDescription("Los Pañitos Húmedos Petys con fragancia son ideales para limpiar a tu mascota diariamente, neutralizando los malos olores y dejándola con un agradable aroma");
        productRequestUpdateDTO.setQuantityAvailable(50);
        productRequestUpdateDTO.setUnitValue(204.0f);
        productRequestUpdateDTO.setTaxValue(908.0f);
        productRequestUpdateDTO.setBaseValue(9000.0f);
        return productRequestUpdateDTO;
    }
}
