package com.companyproducts.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "company")
@Data
public class Company implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int companyId;
    private String companyName;
    @NonNull()
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    @Transient
    private List<Product> productList;

    public Company() {
    }

    public Company(int companyId, String companyName, String password, List<Product> productList) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.password = password;
        this.productList = productList;
    }

    public List<Product> getProduct() {
        return productList;
    }

    public void setProduct(List<Product> productList) {
        this.productList = productList;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", password='" + password + '\'' +
                ", productList=" + productList +
                '}';
    }
}
