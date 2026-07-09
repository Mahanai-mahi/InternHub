package com.internhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.internhub.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    Student findByEmail(String email);

}