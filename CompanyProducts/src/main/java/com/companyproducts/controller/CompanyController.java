package com.companyproducts.controller;

import com.companyproducts.constant.APIConstant;
import com.companyproducts.entities.Company;
import com.companyproducts.service.CompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(APIConstant.COMPANY_SERVICE_BASE_URL)
public class CompanyController {

    private final CompanyService service;

    public CompanyController(CompanyService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Company> add(@RequestBody Company company) {
        return ResponseEntity.ok(service.add(company));
    }

    @GetMapping("/{companyId}")
    public ResponseEntity<Company> get(@PathVariable("companyId") int companyId) {
        return ResponseEntity.ok(service.get(companyId));
    }

    @GetMapping
    public ResponseEntity<List<Company>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
}
