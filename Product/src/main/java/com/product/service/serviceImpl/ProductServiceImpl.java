package com.product.service.serviceImpl;

import com.product.entities.Product;
import com.product.exceptions.ProductException;
import com.product.repository.ProductRepository;
import com.product.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product add(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product get(int productId) {
        return productRepository.findById(productId).orElseThrow(()-> new ProductException("No product found."));
    }

    @Override
    public List<Product> getAll() {

        return productRepository.findAll();
    }

    @Override
    public List<Product> getProdcutByCompanyId(int companyId) {
        return productRepository.findByCompanyId(companyId);
    }
}
