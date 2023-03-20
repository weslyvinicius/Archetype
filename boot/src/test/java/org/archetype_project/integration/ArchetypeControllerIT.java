package org.archetype_project.integration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
@Disabled
public class ArchetypeControllerIT {

    @Autowired
    private MockMvc mockMvc;



    @BeforeEach
    void setUp() throws IOException {
    }

    @Test
    void createProduct(){
    }

    @Test
    void getProductsAPI() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/archetype")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding(StandardCharsets.UTF_8)
                )
                .andDo(MockMvcResultHandlers.print());
    }
}
