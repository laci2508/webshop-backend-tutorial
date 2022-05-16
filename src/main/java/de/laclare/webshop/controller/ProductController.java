package de.laclare.webshop.controller;

import de.laclare.webshop.model.ProductCreateRequest;
import de.laclare.webshop.model.ProductResponse;
import de.laclare.webshop.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class ProductController {

    ProductRepository productRepository = new ProductRepository();

    @GetMapping("/products")
    public List<ProductResponse> getAllProducts(
            @RequestParam(required = false) String tag
    ) {
        if (productRepository.findAll(tag) != null) return productRepository.findAll(tag);
        else return Collections.emptyList();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity <ProductResponse> getProductById(
            @PathVariable String id
    ) {
        if (productRepository.findById(id) != null) return ResponseEntity.ok(productRepository.findById(id));
        else return ResponseEntity.notFound().build();
    }

    @DeleteMapping ("/products/{id}")
    public ResponseEntity deleteProduct(
            @PathVariable String id
    ) {
        productRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping ("/products")
    public ProductResponse createProduct(
            @RequestBody ProductCreateRequest request
    ) {
        return productRepository.save(request);
    }
}
