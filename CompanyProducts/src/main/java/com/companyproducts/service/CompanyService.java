package com.companyproducts.service;


import com.companyproducts.entities.Company;

import java.util.List;

public interface CompanyService {
    public Company add(Company company);
    public Company get(int companyId);
    public List<Company> getAll();
}
