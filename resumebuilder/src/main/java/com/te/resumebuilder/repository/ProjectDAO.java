package com.te.resumebuilder.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.te.resumebuilder.beans.ProjectsInfo;

@Repository
public interface ProjectDAO extends CrudRepository<ProjectsInfo, String> {

	public ProjectsInfo save(ProjectsInfo projectsInfo);
}
