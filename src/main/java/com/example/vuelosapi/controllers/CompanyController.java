package com.example.vuelosapi.controllers;

import com.example.vuelosapi.models.Company;
import com.example.vuelosapi.models.Flight;
import com.example.vuelosapi.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    //Create
    @PostMapping("/create")
    public void createCompany(@RequestBody Company company){
        companyService.createCompany(company);
    }

    //Read
    @GetMapping("/all")
    public List<Company> getAllCompanies(){
        return companyService.getAllCompanies();
    }

    @GetMapping("/{id}")
    public Optional<Company> findCompanyById(@PathVariable Long id){
        return companyService.findCompanyById(id);
    }

    //update
    @PutMapping("/update")
    public Optional<Company> updateCompany(@RequestBody Company company){
        return companyService.updateCompany(company);
    }
    //delete
    @DeleteMapping("/delete/{id}")
    public void deleteCompany(@PathVariable Long id){
        companyService.deleteCompany(id);
    }

}
