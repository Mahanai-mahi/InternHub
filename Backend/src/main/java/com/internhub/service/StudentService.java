package com.internhub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.internhub.entity.Student;
import com.internhub.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    // Register
    public Student register(Student student) {

        return repository.save(student);

    }

    // Login
    public Student login(String email, String password) {

        System.out.println("========== LOGIN REQUEST ==========");
        System.out.println("Email Entered : " + email);

        Student student = repository.findByEmail(email);

        if (student == null) {

            System.out.println("Student not found in database.");
            return null;

        }

        System.out.println("Student Found : " + student.getName());
        System.out.println("Database Password : " + student.getPassword());
        System.out.println("Entered Password : " + password);

        if (student.getPassword().equals(password)) {

            System.out.println("Login Successful");
            return student;

        }

        System.out.println("Incorrect Password");
        return null;

    }

    // Get All Students
    public List<Student> getAllStudents() {

        return repository.findAll();

    }

    // Get Student By ID
    public Student getStudentById(int id) {

        return repository.findById(id).orElse(null);

    }

    // Update Student
    public Student updateStudent(int id, Student student) {

        Student existing = repository.findById(id).orElse(null);

        if (existing != null) {

            existing.setName(student.getName());
            existing.setBranch(student.getBranch());
            existing.setSkills(student.getSkills());
            existing.setGithubLink(student.getGithubLink());
            existing.setLinkedinLink(student.getLinkedinLink());
            existing.setResume(student.getResume());

            return repository.save(existing);

        }

        return null;

    }

    // Delete Student
    public String deleteStudent(int id) {

        repository.deleteById(id);

        return "Student Deleted Successfully";

    }

}