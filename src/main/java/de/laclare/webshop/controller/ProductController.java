package de.laclare.webshop.controller;

import de.laclare.webshop.model.ProductResponse;
import de.laclare.webshop.repository.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class ProductController {

    ProductRepository productrepository = new ProductRepository();

    @GetMapping("/products")
    public List<ProductResponse> getAllProducts(
            @RequestParam(required = false) String tag
    ) {
        if (productrepository.findAll(tag) != null) return productrepository.findAll(tag);
        else return Collections.emptyList();
    }
}
