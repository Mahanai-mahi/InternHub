package com.internhub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.internhub.entity.Internship;
import com.internhub.service.InternshipService;

@RestController
@RequestMapping("/api/internships")
@CrossOrigin(origins = "*")
public class InternshipController {

    @Autowired
    private InternshipService internshipService;

    // Add Internship
    @PostMapping
    public Internship addInternship(@RequestBody Internship internship) {
        return internshipService.saveInternship(internship);
    }

    // Get All Internships
    @GetMapping
    public List<Internship> getAllInternships() {
        return internshipService.getAllInternships();
    }

    // Get Internship by ID
    @GetMapping("/{id}")
    public Internship getInternshipById(@PathVariable int id) {
        return internshipService.getInternshipById(id);
    }

    // Update Internship
    @PutMapping("/{id}")
    public Internship updateInternship(@PathVariable int id,
                                       @RequestBody Internship internship) {
        return internshipService.updateInternship(id, internship);
    }

    // Delete Internship
    @DeleteMapping("/{id}")
    public String deleteInternship(@PathVariable int id) {
        return internshipService.deleteInternship(id);
    }
}