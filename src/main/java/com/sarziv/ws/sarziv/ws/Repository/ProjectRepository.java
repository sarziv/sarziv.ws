package com.sarziv.ws.sarziv.ws.Repository;

import com.sarziv.ws.sarziv.ws.Model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}