package com.companyproducts;

import com.companyproducts.constant.APIConstant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = APIConstant.BASE_PATH)
public class CompanyProductsApplication {
    public static void main(String[] args) {
        SpringApplication.run(CompanyProductsApplication.class, args);
    }
}
