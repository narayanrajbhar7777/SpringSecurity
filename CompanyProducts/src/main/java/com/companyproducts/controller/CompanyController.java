package com.companyproducts.controller;

import com.companyproducts.entities.Company;
import com.companyproducts.exceptions.CompanyException;
import com.companyproducts.service.CompanyService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService service;

    public CompanyController(CompanyService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Company> add(@RequestBody Company company) {
        try {
            return ResponseEntity.ok(service.add(company));
        } catch (Exception e) {
            throw new CompanyException("company not saved due to error: " + e.getMessage());
        }
    }

    @GetMapping("/{companyId}")
    public ResponseEntity<Company> get(@PathVariable("companyId") int companyId) {
        try {
            return ResponseEntity.ok(service.get(companyId));
        } catch (Exception e) {
            throw new CompanyException("Exception occurs: " + e);
        }
    }

    @GetMapping
    public ResponseEntity<List<Company>> getAll() {
        try {
            return ResponseEntity.ok(service.getAll());
        } catch (Exception e) {
            throw new CompanyException("Error occurs: " + e.getMessage());
        }
    }
}
