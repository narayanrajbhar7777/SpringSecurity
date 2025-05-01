package com.companyproducts.service.impl;

import com.companyproducts.entities.Company;
import com.companyproducts.entities.Product;
import com.companyproducts.exceptions.CompanyException;
import com.companyproducts.repository.CompanyRepository;
import com.companyproducts.service.CompanyService;
import com.companyproducts.service.ProductClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import javax.sound.sampled.Port;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    private final RestTemplate restTemplate;  //1-> Way
    private final WebClient.Builder webClientBuilder; //2-> Way
    private final ProductClient productClient;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
    public CompanyServiceImpl(CompanyRepository companyRepository, RestTemplate restTemplate, WebClient.Builder webClientBuilder, ProductClient productClient) {
        this.companyRepository = companyRepository;
        this.restTemplate = restTemplate;
        this.webClientBuilder = webClientBuilder;
        this.productClient = productClient;
    }

    @Override
    public Company add(Company company) {
        company.setPassword(encoder.encode(company.getPassword()));
        return companyRepository.save(company);
    }

    @Override
    public Company get(int companyId) {
//            Product product = getProductByRestTemplate("http://localhost:8083/product/companyId/" + companyId);
//            Product product = getProductByWebClient("http://localhost:8083/product/companyId/" + companyId);
//            List<Product> productList = getProductListByRestTemplate("http://localhost:8083/product/companyId/" + companyId);
        List<Product> productList = getProductListByOpenFeignClient(companyId);
        Company company = companyRepository.findById(companyId).orElseThrow(() -> new CompanyException("Company not found."));
        company.setProduct(productList);
        return company;
    }

    private List<Product> getProductListByOpenFeignClient(int companyId) {
        return productClient.getProdcutByCompanyId(companyId);
    }

    @Override
    public List<Company> getAll() {
        return companyRepository.findAll().stream().map(conpany ->
                {
                    ResponseEntity<List<Product>> response = restTemplate.exchange("http://localhost:8083/product/companyId/" + conpany.getCompanyId(), HttpMethod.GET, null, new ParameterizedTypeReference<List<Product>>() {});
                    List<Product> getProductList = response.getBody();
                    if (Objects.isNull(getProductList))
                        getProductList = new ArrayList<>();
                    conpany.setProduct(getProductList);
                    return conpany;
                }
        ).toList();
    }

    private List<Product> getProductListByRestTemplate(String sURL) {
        ResponseEntity<List<Product>> response = restTemplate.exchange(sURL, HttpMethod.GET, null, new ParameterizedTypeReference<List<Product>>() {
        });
        List<Product> getProductList = response.getBody();
        if (Objects.isNull(getProductList)) {
            getProductList = new ArrayList<>();
        }
        return getProductList;
    }

    private Product getProductByRestTemplate(String sURL) {
        Product product;
        product = restTemplate.getForObject(sURL, Product.class);
        if (Objects.isNull(product)) {
            product = new Product();
        }
        return product;
    }
    private Product getProductByWebClient(String sURL) {
        Product product;
        product = webClientBuilder.build().get().uri(sURL).retrieve().bodyToMono(Product.class).block();/*2-> Way*/
        if (Objects.isNull(product)) {
            product = new Product();
        }
        return product;
    }
}
