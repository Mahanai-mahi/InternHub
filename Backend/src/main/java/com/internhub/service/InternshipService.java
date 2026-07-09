package com.internhub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.internhub.entity.Internship;
import com.internhub.repository.InternshipRepository;

@Service
public class InternshipService {

    @Autowired
    private InternshipRepository internshipRepository;

    // Save Internship
    public Internship saveInternship(Internship internship) {

        System.out.println("========== SAVE INTERNSHIP ==========");
        System.out.println("Title: " + internship.getTitle());
        System.out.println("Company: " + internship.getCompany());
        System.out.println("Duration: " + internship.getDuration());
        System.out.println("Stipend: " + internship.getStipend());
        System.out.println("Skills: " + internship.getRequiredSkills());
        System.out.println("Description: " + internship.getDescription());

        try {

            Internship savedInternship = internshipRepository.save(internship);

            System.out.println("Internship Saved Successfully!");

            return savedInternship;

        } catch (Exception e) {

            System.out.println("Error while saving internship:");

            e.printStackTrace();

            throw e;
        }
    }

    // Get All Internships
    public List<Internship> getAllInternships() {
        return internshipRepository.findAll();
    }

    // Get Internship By ID
    public Internship getInternshipById(int id) {
        return internshipRepository.findById(id).orElse(null);
    }

    // Update Internship
    public Internship updateInternship(int id, Internship internship) {

        Internship existingInternship =
                internshipRepository.findById(id).orElse(null);

        if (existingInternship != null) {

            existingInternship.setTitle(internship.getTitle());
            existingInternship.setCompany(internship.getCompany());
            existingInternship.setDuration(internship.getDuration());
            existingInternship.setStipend(internship.getStipend());
            existingInternship.setRequiredSkills(internship.getRequiredSkills());
            existingInternship.setDescription(internship.getDescription());

            return internshipRepository.save(existingInternship);
        }

        return null;
    }

    // Delete Internship
    public String deleteInternship(int id) {

        internshipRepository.deleteById(id);

        return "Internship Deleted Successfully";
    }
}