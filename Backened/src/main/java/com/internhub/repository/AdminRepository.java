package com.internhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.internhub.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin,Integer>{

    Admin findByEmail(String email);

}