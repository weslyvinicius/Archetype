package org.archetype_project.feign;

import org.archetype_project.doman.response.ProductsOutput;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "dummyjson", url = "https://dummyjson.com")
public interface DummyjsonFeignClient {

    @GetMapping("/products")
    ProductsOutput getProcuts();
}
