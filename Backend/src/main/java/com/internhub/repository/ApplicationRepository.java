package com.internhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.internhub.entity.Application;

public interface ApplicationRepository extends JpaRepository<Application, Integer> {

    long countByStatus(String status);

}