package br.com.api.product.controller;

import br.com.api.product.dto.ProductDTO;
import br.com.api.product.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;


    @GetMapping("/products")
    List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/category/{categoryId}")
    List<ProductDTO> findByCategoryId(@PathVariable long categoryId) {
        return productService.getProductByCategoryId(categoryId);
    }

    @GetMapping("/products/{productIdentifier}")
    ProductDTO findByProductIdentifier(@PathVariable String productIdentifier) {
        return productService.findByProductIdentifier(productIdentifier);
    }

    @PostMapping("/products")
    ProductDTO create(@RequestBody @Valid ProductDTO productDTO) {
        return productService.save(productDTO);
    }

    @DeleteMapping("/products/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable long id) {
        productService.delete(id);
    }
}
