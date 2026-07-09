package com.internhub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.internhub.entity.Application;
import com.internhub.service.ApplicationService;

@RestController
@RequestMapping("/application")
@CrossOrigin(origins = "*")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

   @PostMapping("/add")
public Application addApplication(@RequestBody Application application) {

    System.out.println("===== APPLICATION RECEIVED =====");
    System.out.println("Student ID: " + application.getStudentId());
    System.out.println("Internship ID: " + application.getInternshipId());
    System.out.println("Status: " + application.getStatus());

    return applicationService.saveApplication(application);
}

    @GetMapping("/all")
    public List<Application> getAllApplications() {
        return applicationService.getAllApplications();
    }

    @GetMapping("/{id}")
    public Application getApplicationById(@PathVariable int id) {
        return applicationService.getApplicationById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteApplication(@PathVariable int id) {
        return applicationService.deleteApplication(id);
    }

    @PutMapping("/status/{id}")
public Application updateStatus(
        @PathVariable int id,
        @RequestParam String status) {

    return applicationService.updateStatus(id, status);
}
}