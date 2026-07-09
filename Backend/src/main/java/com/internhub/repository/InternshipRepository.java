package com.internhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.internhub.entity.Internship;

@Repository
public interface InternshipRepository extends JpaRepository<Internship, Integer> {

}