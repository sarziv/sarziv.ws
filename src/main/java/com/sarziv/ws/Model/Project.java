package com.sarziv.ws.Model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "projects")

public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NotBlank
    @Column(name = "project_name")
    private String project_name;

    @NotBlank
    @Column(name = "project_info")
    private String project_info;


    Project(){
        super();
    }

    Project(Long id, String project_name,String project_info){
        super();
        this.id = id;
        this.project_name = project_name;
        this.project_info = project_info;
    }


    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getProject_name() {

        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getProject_info() {

        return project_info;
    }

    public void setProject_info(String project_info) {

        this.project_info = project_info;
    }

}
