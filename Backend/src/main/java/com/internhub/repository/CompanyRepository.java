package com.internhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.internhub.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

    Company findByEmail(String email);

}