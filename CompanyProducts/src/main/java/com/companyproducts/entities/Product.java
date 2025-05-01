package com.companyproducts.entities;

import lombok.Data;

@Data
public class Product {
    private int productId;
    private String productName;
    private float price;
    private String description;
    private int companyId;

    public Product() {
    }

    public Product(int productId, String productName, float price, String description, int companyId) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.companyId = companyId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }
    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", companyId=" + companyId +
                '}';
    }
}
