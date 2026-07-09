package com.internhub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.internhub.entity.Application;
import com.internhub.repository.ApplicationRepository;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    public Application saveApplication(Application application) {
        return applicationRepository.save(application);
    }

    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    public Application getApplicationById(int id) {
    return applicationRepository.findById(id).orElse(null);
}

public String deleteApplication(int id) {
    applicationRepository.deleteById(id);
    return "Application Deleted Successfully";
}

public Application updateStatus(int id, String status) {

    Application application = applicationRepository.findById(id).orElse(null);

    if (application != null) {
        application.setStatus(status);
        return applicationRepository.save(application);
    }

    return null;
}
}