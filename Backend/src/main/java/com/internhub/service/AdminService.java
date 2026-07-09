package com.internhub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.internhub.entity.Admin;
import com.internhub.repository.AdminRepository;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public Admin login(String email,String password){

        Admin admin = adminRepository.findByEmail(email);

        if(admin!=null && admin.getPassword().equals(password)){

            return admin;

        }

        return null;

    }

}