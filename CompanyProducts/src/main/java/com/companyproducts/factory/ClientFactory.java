package com.companyproducts.factory;


import com.companyproducts.enums.CLIENTS;
import com.companyproducts.service.ProductClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class ClientFactory {

    private final RestTemplate restTemplate;
    private final WebClient getWebClientBuilder;
    private final ProductClient productClient;

    public ClientFactory(RestTemplate restTemplate, WebClient getWebClientBuilder, ProductClient productClient) {
        this.restTemplate = restTemplate;
        this.getWebClientBuilder = getWebClientBuilder;
        this.productClient = productClient;
    }

    public Object getClient(CLIENTS clientType) {
        return switch (clientType) {
            case REST_TEMPLATE -> restTemplate;
            case WEB_CLIENT -> getWebClientBuilder;
            case FEIGN_CLIENT -> productClient;
            default -> throw new IllegalArgumentException("Unsupported client type: " + clientType);
        };
    }
}
