package com.product.controller;

import com.product.entities.Product;
import com.product.exceptions.ProductException;
import com.product.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService service;
    public ProductController (ProductService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Product> add(@RequestBody Product product){
        try{
            return ResponseEntity.ok(service.add(product));
        } catch (Exception e) {
            throw new ProductException(""+e);
        }
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> get(@PathVariable("productId") int productId) {
        Product product = service.get(productId);
        return ResponseEntity.ok(product);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }
    //http://localhost:8083/product/companyId/1
    @GetMapping("/companyId/{companyId}")
    public List<Product> getProductByCompanyId(@PathVariable("companyId") int companyId){
        try{
            return service.getProdcutByCompanyId(companyId);
        } catch(Exception e){
            throw new ProductException("Product not found by companyId: "+companyId);
        }
    }

}
