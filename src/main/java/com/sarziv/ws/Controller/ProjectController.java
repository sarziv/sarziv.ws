package com.sarziv.ws.Controller;

import com.sarziv.ws.Exception.ProjectNotFoundException;
import com.sarziv.ws.Model.Project;
import com.sarziv.ws.Repository.ProjectRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;


    @GetMapping()
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @GetMapping("/{id}")
    public Project getProject(@PathVariable("id") Long id) {
        Optional<Project> project = projectRepository.findById(id);

        if (!project.isPresent())
            throw new ProjectNotFoundException("id-" + id);
        return project.get();
    }

    @PostMapping
    public Project create(Project create) {
        return projectRepository.save(create);
    }

    @PutMapping("/{id}")
    Project updateProject(@RequestBody Project newProject, @PathVariable Long id) {

        if(!projectRepository.findById(id).isPresent()){
            throw new ProjectNotFoundException("Id not Found: "+ id);
        }

        projectRepository.findById(id)
                .map(project -> {
                    project.setId(newProject.getId());
                    project.setProject_name(newProject.getProject_name());
                    project.setProject_info(newProject.getProject_info());
                    return projectRepository.save(newProject);
                })
                .orElseGet(() -> {
                   throw new ProjectNotFoundException("Error:");
                });
        return projectRepository.save(newProject);
    }


    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable long id) {
        projectRepository.deleteById(id);
    }
}