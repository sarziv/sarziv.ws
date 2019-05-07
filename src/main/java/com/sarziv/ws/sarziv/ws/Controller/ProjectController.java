package com.sarziv.ws.sarziv.ws.Controller;

import com.sarziv.ws.sarziv.ws.Model.Project;
import com.sarziv.ws.sarziv.ws.Repository.ProjectRepository;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("/api")
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;


    @GetMapping("/projects")
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @GetMapping("/projects/{id}")
    public String getProjectById(@PathVariable(value = "id") Long projectId) {
        return projectRepository.findById(projectId).map(project -> ResponseEntity.ok().body(project).orE)
    }
}