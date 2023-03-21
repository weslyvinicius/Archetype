package org.archetype_project.integration;

import org.archetype_project.config.ObjectMapperUtils;
import org.archetype_project.domain.Product;
import org.archetype_project.presentation.response.ProductResponse;
import org.archetype_project.util.ConstantsNames;
import org.archetype_project.util.ConstantsTestIT;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.StandardCharsets;
import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ArchetypeControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void createProduct() throws Exception {
        var productBody = ObjectMapperUtils.mapperReader(ConstantsTestIT.PRODUCT_CREATE_REQUEST, Product.class);

        String resultRequest = mockMvc.perform(MockMvcRequestBuilders.post(ConstantsNames.URI_VERSION_NAME)
                        .content(ObjectMapperUtils.writeValueAsString(productBody))
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
    void getProductsAPI() throws Exception {

        String resultRequest = mockMvc.perform(MockMvcRequestBuilders.get(ConstantsNames.URI_VERSION_NAME)
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding(StandardCharsets.UTF_8)
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn()
                .getResponse().getContentAsString();

        var productResponse = ObjectMapperUtils.parseList(resultRequest, List.class, ProductResponse.class);

        Assertions.assertEquals(30, productResponse.size());

    }
}
