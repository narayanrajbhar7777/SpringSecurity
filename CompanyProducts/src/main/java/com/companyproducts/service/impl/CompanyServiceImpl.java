package com.companyproducts.service.impl;

import com.companyproducts.constant.APIConstant;
import com.companyproducts.entities.Company;
import com.companyproducts.entities.Product;
import com.companyproducts.enums.CLIENTS;
import com.companyproducts.exceptions.CompanyException;
import com.companyproducts.factory.ClientFactory;
import com.companyproducts.repository.CompanyRepository;
import com.companyproducts.service.CompanyService;
import com.companyproducts.service.ProductClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;


@Service
public class CompanyServiceImpl implements CompanyService {
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
    private final CompanyRepository companyRepository;
    private final ClientFactory clientFactory;
    public CompanyServiceImpl(CompanyRepository companyRepository, ClientFactory clientFactory) {
        this.companyRepository = companyRepository;
        this.clientFactory = clientFactory;
    }

    @Override
    public Company add(Company company) {
        company.setPassword(encoder.encode(company.getPassword()));
        return companyRepository.save(company);
    }

    @Override
    public Company get(int companyId) {
        List<Product> productList = getProductListByOpenFeignClient(companyId);
        Company company = companyRepository.findById(companyId).orElseThrow(() -> new CompanyException("Company not found."));
        company.setProductList(productList);
        return company;
    }

    private List<Product> getProductListByOpenFeignClient(int companyId) {
        return ((ProductClient) clientFactory.getClient(CLIENTS.FEIGN_CLIENT)).getProdcutByCompanyId(companyId);
    }


    @Override
    public List<Company> getAll() {
        return companyRepository.findAll().stream()
                .map(company -> {
                    List<Product> products = getProductsWithCircuitBreaker(Long.valueOf(company.getCompanyId()));
                    company.setProductList(products);
                    return company;
                }).toList();
    }

    @CircuitBreaker(name = "productService", fallbackMethod = "fallbackProductList")
    public List<Product> getProductsWithCircuitBreaker(Long companyId) {
        String url = APIConstant.PRODUCT_SERVICE_BASE_URL + companyId;
        RestTemplate restTemplate = (RestTemplate) clientFactory.getClient(CLIENTS.REST_TEMPLATE);

        ResponseEntity<List<Product>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Product>>() {}
        );
        return response.getBody() != null ? response.getBody() : new ArrayList<>();
    }

    public List<Product> fallbackProductList(Long companyId, Throwable ex) {
        System.err.println("Fallback triggered for companyId " + companyId + ": " + ex.getMessage());
        return new ArrayList<>();
    }



    private List<Product> getProductListByRestTemplate(String sURL) {
        RestTemplate restTemplate = (RestTemplate) clientFactory.getClient(CLIENTS.REST_TEMPLATE);

        return restTemplate.
                exchange(sURL, HttpMethod.GET, null, new ParameterizedTypeReference<List<Product>>() {
                }).getBody();
    }

    private Product getProductByRestTemplate(String sURL) {
        RestTemplate restTemplate = (RestTemplate) clientFactory.getClient(CLIENTS.REST_TEMPLATE);

        return restTemplate.getForObject(sURL, Product.class);
    }

    private Product getProductByWebClient(String sURL) {
        WebClient web = (WebClient) clientFactory.getClient(CLIENTS.WEB_CLIENT);
        return web.get().uri(sURL).retrieve().bodyToMono(Product.class).block();/*2-> Way*/
    }
}
