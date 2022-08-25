package com.pms.service;

import java.util.List;

import com.pms.entity.Project;
import com.pms.exception.ProjectNotFoundException;

public interface ProjectService {

	public String addProjectDetails(Project project);

	public String updateProjectDetails(long projectId, Project project);

	public String deleteProjectDetails(long projectId);

	public List<Project> listProjectDetails();
	
	public Project getProjectById(long projectId) throws ProjectNotFoundException;

}
