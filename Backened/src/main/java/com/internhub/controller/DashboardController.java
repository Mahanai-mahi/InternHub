package com.internhub.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.internhub.service.DashboardService;

@RestController
@RequestMapping("/dashboard")
@CrossOrigin(origins="*")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/stats")
    public Map<String, Long> getDashboardStats(){

        Map<String, Long> stats = new HashMap<>();

        stats.put("internships", dashboardService.getTotalInternships());

        stats.put("applications", dashboardService.getTotalApplications());

        stats.put("selected", dashboardService.getSelectedStudents());

        stats.put("rejected", dashboardService.getRejectedStudents());

        return stats;
    }

}