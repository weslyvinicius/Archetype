package org.archetype_project.contracts;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import org.archetype_project.presentation.request.ProductRequest;
import org.archetype_project.presentation.response.ProductResponse;
import org.archetype_project.util.ConstantsNames;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Schema(description = "API REST Archetype Presentation")
@RequestMapping(ConstantsNames.URI_VERSION_NAME)
public interface ArchetypeContract {

    @Operation(description = "Create Product")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ProductResponse createProduct(ProductRequest productRequest);

    @Operation(description = "List Products DummyJson API")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<ProductResponse> getProductAPI();
}
