package com.internhub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.internhub.entity.Company;
import com.internhub.repository.CompanyRepository;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    // Register Company
    public Company register(Company company) {

        return companyRepository.save(company);

    }

    // Login Company
    public Company login(String email, String password) {

        Company company = companyRepository.findByEmail(email);

        if (company != null && company.getPassword().equals(password)) {

            return company;

        }

        return null;

    }

    // Existing Methods

    public Company saveCompany(Company company) {
        return companyRepository.save(company);
    }

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public Company getCompanyById(int id) {
        return companyRepository.findById(id).orElse(null);
    }

    public Company updateCompany(int id, Company company) {

        Company existingCompany =
                companyRepository.findById(id).orElse(null);

        if (existingCompany != null) {

            existingCompany.setCompanyName(company.getCompanyName());
            existingCompany.setEmail(company.getEmail());
            existingCompany.setPassword(company.getPassword());
            existingCompany.setLocation(company.getLocation());
            existingCompany.setIndustry(company.getIndustry());

            return companyRepository.save(existingCompany);
        }

        return null;
    }

    public String deleteCompany(int id) {

        companyRepository.deleteById(id);

        return "Company Deleted Successfully";
    }

}