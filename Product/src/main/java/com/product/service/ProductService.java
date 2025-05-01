package com.product.service;

import com.product.entities.Product;

import java.util.List;

public interface ProductService {
    public Product add(Product product);

    public Product get(int productId);

    public List<Product> getAll();

    public List<Product> getProdcutByCompanyId(int companyId);

}
