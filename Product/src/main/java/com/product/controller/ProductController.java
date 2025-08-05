package com.product.controller;

import com.product.entities.Product;
import com.product.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Product> add(@RequestBody Product product) {
        return ResponseEntity.ok(service.add(product));

    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> get(@PathVariable("productId") int productId) {
        Product product = service.get(productId);
        return ResponseEntity.ok(product);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    //http://localhost:8083/product/companyId/1
    @GetMapping("/companyId/{companyId}")
    public List<Product> getProductByCompanyId(@PathVariable("companyId") int companyId) {
        return service.getProdcutByCompanyId(companyId);
    }
}
