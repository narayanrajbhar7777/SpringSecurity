package com.companyproducts.service;

import com.companyproducts.entities.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@FeignClient(url="http://localhost:8083" , value = "Product")
//@FeignClient(url="PRODUCT-SERVICE" , value = "product")
public interface ProductClient {
    @GetMapping("/product/companyId/{companyId}")
    List<Product> getProdcutByCompanyId(@PathVariable("companyId") int companyId);
}
