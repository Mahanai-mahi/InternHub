package com.internhub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.internhub.entity.Student;
import com.internhub.service.StudentService;

@RestController
@RequestMapping("/student")
@CrossOrigin("*")
public class StudentController {

    @Autowired
    private StudentService service;

    // Register Student
    @PostMapping("/register")
    public Student register(@RequestBody Student student) {

        return service.register(student);

    }

    // Student Login
    @PostMapping("/login")
    public Student login(@RequestBody Student student) {

        return service.login(student.getEmail(), student.getPassword());

    }

    // Get All Students
    @GetMapping("/all")
    public List<Student> getAllStudents() {

        return service.getAllStudents();

    }

    // Get Student By ID
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id) {

        return service.getStudentById(id);

    }

    // Update Student
    @PutMapping("/update/{id}")
    public Student updateStudent(@PathVariable int id,
                                 @RequestBody Student student) {

        return service.updateStudent(id, student);

    }

    // ⭐ Delete Student
    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id) {

        return service.deleteStudent(id);

    }

}