package com.companyproducts.constant;

public class APIConstant {
    public static final String BASE_URL = "http://localhost:8083/api";
    public static final String COMPANY_SERVICE_BASE_URL = "/api/company";
    public static final String PRODUCT_SERVICE_BASE_URL = BASE_URL + "/product/companyId/";
    public static final String BASE_PATH = "com.companyproducts.service";
    //        Product product = getProductByRestTemplate("http://localhost:8083/product/companyId/" + companyId);
//            Product product = getProductByWebClient("http://localhost:8083/product/companyId/" + companyId);
//            List<Product> productList = getProductListByRestTemplate("http://localhost:8083/product/companyId/" + companyId);
}
