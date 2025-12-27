package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Project;
import com.examly.springapp.repository.ProjectRepo;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepo projectRepo;

    public Project createProject(Project project) {
        return projectRepo.save(project);
    }

    public List<Project> getAllProjects() {
        return projectRepo.findAll();
    }

    public Project getProjectById(long id) {
        return projectRepo.findById(id).orElse(null);
    }

    public Project updateProject(long id, Project project) {
        Project existingProject = projectRepo.findById(id).orElse(null);
        if (existingProject != null) {
            existingProject.setProjectName(project.getProjectName());
            existingProject.setDescription(project.getDescription());
            existingProject.setStatus(project.getStatus());
            return projectRepo.save(existingProject);
        }
        return null;
    }

    public List<Project> getProjectsByStatus(String status) {
        return projectRepo.findByStatus(status);
    }
}
