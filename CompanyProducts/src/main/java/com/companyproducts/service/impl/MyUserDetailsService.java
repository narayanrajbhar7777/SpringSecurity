package com.companyproducts.service.impl;

import com.companyproducts.entities.Company;
import com.companyproducts.repository.CompanyRepository;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class MyUserDetailsService {//implements UserDetailsService {

//    private final CompanyRepository repository;
//
//    public MyUserDetailsService(CompanyRepository repository) {
//        this.repository = repository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        System.out.println("22; ====================================================username: "+username);
//        Company company = repository.findCompanyByCompanyName(username);
//        if (StringUtils.hasText(company.getCompanyName())) {
//            return new UserDetailImpl(company);
//        }
//        throw new UsernameNotFoundException("User not found.");
//    }
}

