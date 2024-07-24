
package com.example.vuelosapi.services;

import com.example.vuelosapi.models.Company;
import com.example.vuelosapi.repositorys.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    //Create
    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    public List<Company> getAllCompanies() {
       return companyRepository.findAll();
    }

    public Optional<Company> findCompanyById(Long id){
        return companyRepository.findById(id);
    }

    public Optional<Company> updateCompany(Company company) {
        companyRepository.save(company);
        return companyRepository.findById(company.getId());
    }

    public void deleteCompany(Long id){
        companyRepository.deleteById(id);
    }
}

