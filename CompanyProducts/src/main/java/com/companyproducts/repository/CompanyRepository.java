package com.companyproducts.repository;

import com.companyproducts.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Integer> {
    Company findCompanyByCompanyName(String companyName);
}
