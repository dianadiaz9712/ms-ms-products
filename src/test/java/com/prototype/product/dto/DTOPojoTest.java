package com.prototype.product.dto;

import org.junit.Test;
import pl.pojo.tester.api.assertion.Method;

import static pl.pojo.tester.api.assertion.Assertions.assertPojoMethodsFor;

public class DTOPojoTest {

    @Test
    public void ProductResquestDTOTest(){
        final Class<?> classUnderTest = ProductResquestDTO.class;
        assertPojoMethodsFor(classUnderTest).testing(Method.GETTER, Method.SETTER).areWellImplemented();
    }

    @Test
    public void ProductRequestUpdateDTOTest(){
        final Class<?> classUnderTest = ProductRequestUpdateDTO.class;
        assertPojoMethodsFor(classUnderTest).testing(Method.GETTER, Method.SETTER).areWellImplemented();
    }

    @Test
    public void ProductResponseDTOTest(){
        final Class<?> classUnderTest = ProductResponseDTO.class;
        assertPojoMethodsFor(classUnderTest).testing(Method.GETTER, Method.SETTER).areWellImplemented();
    }

    @Test
    public void MessageResponseTest(){
        final Class<?> classUnderTest = MessageResponse.class;
        assertPojoMethodsFor(classUnderTest).testing(Method.GETTER, Method.SETTER).areWellImplemented();
    }
}
