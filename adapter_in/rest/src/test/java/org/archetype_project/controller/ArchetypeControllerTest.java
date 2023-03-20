package org.archetype_project.controller;


import org.archetype_project.config.ObjectMapperUtils;
import org.archetype_project.domain.Product;
import org.archetype_project.mapper.ProductMapper;
import org.archetype_project.ports.in.IUseCaseCreateProduct;
import org.archetype_project.ports.in.IUseCaseGetProductDummy;
import org.archetype_project.presentation.request.ProductRequest;
import org.archetype_project.presentation.response.ProductResponse;
import org.archetype_project.util.ConstantsNames;
import org.archetype_project.util.TestConstants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.nio.charset.StandardCharsets;

@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ArchetypeControllerTest {

    private MockMvc mockMvc;

    @Spy
    private ProductMapper productMapper= Mappers.getMapper(ProductMapper.class);

    @Mock
    private IUseCaseCreateProduct useCaseCreateProduct;

    @Mock
    private IUseCaseGetProductDummy useCaseGetProductDummy;

    @BeforeAll
    void setup(){
        ArchetypeController archetypeController = new ArchetypeController(productMapper,
                                                                          useCaseCreateProduct,
                                                                          useCaseGetProductDummy);

        mockMvc = MockMvcBuilders.standaloneSetup(archetypeController).build();
    }

    @Test
    void createProductTest() throws Exception {

        var product = ObjectMapperUtils.mapperReader(TestConstants.PRODUCTS_CREATE_RESPONSE, Product.class);
        Mockito.when(useCaseCreateProduct.createProduct(Mockito.any())).thenReturn(product);


        var produtoRequet = ObjectMapperUtils.mapperReader(TestConstants.PRODUCT_REQUEST, ProductRequest.class);



        String resultRequest = mockMvc.perform(MockMvcRequestBuilders.post(ConstantsNames.URI_VERSION_NAME)
                                      .content(ObjectMapperUtils.writeValueAsString(produtoRequet))
                                      .contentType(MediaType.APPLICATION_JSON)
                                      .characterEncoding(StandardCharsets.UTF_8)
                                      )
                                      .andDo(MockMvcResultHandlers.print())
                                      .andExpect(MockMvcResultMatchers.status().isCreated())
                                      .andReturn()
                                      .getResponse().getContentAsString();

        var productResponse = ObjectMapperUtils.parse(resultRequest, ProductResponse.class);

        Assertions.assertEquals("1", productResponse.id());
        Assertions.assertEquals("iPhone 10", productResponse.title());
        Assertions.assertEquals("An apple mobile which is nothing like apple", productResponse.description());

    }

    @Test
    void getProductDummuyAPITest(){

    }


}