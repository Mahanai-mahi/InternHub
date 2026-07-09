package com.internhub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.internhub.entity.Company;
import com.internhub.service.CompanyService;

@RestController
@RequestMapping("/company")
@CrossOrigin("*")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    // ================= REGISTER =================

    @PostMapping("/register")
    public Company register(@RequestBody Company company) {

        System.out.println("========= COMPANY REGISTER =========");
        System.out.println("Company Name : " + company.getCompanyName());
        System.out.println("Email        : " + company.getEmail());
        System.out.println("Password     : " + company.getPassword());
        System.out.println("Location     : " + company.getLocation());
        System.out.println("Industry     : " + company.getIndustry());
        System.out.println("====================================");

        return companyService.register(company);
    }

    // ================= LOGIN =================

    @PostMapping("/login")
    public Company login(@RequestBody Company company) {

        return companyService.login(
                company.getEmail(),
                company.getPassword());

    }

    // ================= ADD COMPANY =================

    @PostMapping("/add")
    public Company addCompany(@RequestBody Company company) {

        return companyService.saveCompany(company);

    }

    // ================= GET ALL =================

    @GetMapping("/all")
    public List<Company> getAllCompanies() {

        return companyService.getAllCompanies();

    }

    // ================= GET BY ID =================

    @GetMapping("/{id}")
    public Company getCompanyById(@PathVariable int id) {

        return companyService.getCompanyById(id);

    }

    // ================= UPDATE =================

    @PutMapping("/update/{id}")
    public Company updateCompany(@PathVariable int id,
                                 @RequestBody Company company) {

        return companyService.updateCompany(id, company);

    }

    // ================= DELETE =================

    @DeleteMapping("/delete/{id}")
    public String deleteCompany(@PathVariable int id) {

        return companyService.deleteCompany(id);

    }

}