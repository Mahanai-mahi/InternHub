package com.internhub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.internhub.repository.ApplicationRepository;
import com.internhub.repository.InternshipRepository;

@Service
public class DashboardService {

    @Autowired
    private InternshipRepository internshipRepository;

    @Autowired
    private ApplicationRepository applicationRepository;

    public long getTotalInternships() {
        return internshipRepository.count();
    }

    public long getTotalApplications() {
        return applicationRepository.count();
    }

    public long getSelectedStudents() {
        return applicationRepository.countByStatus("Selected");
    }

    public long getRejectedStudents() {
        return applicationRepository.countByStatus("Rejected");
    }

}