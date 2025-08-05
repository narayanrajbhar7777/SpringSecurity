package com.companyproducts.entities;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class Product {
    private int productId;
    private String productName;
    private float price;
    private String description;
    private int companyId;
}
