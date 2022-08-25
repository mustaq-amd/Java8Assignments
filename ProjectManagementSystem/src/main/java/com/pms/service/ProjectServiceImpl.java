package com.pms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.entity.Project;
import com.pms.exception.ProjectNotFoundException;
import com.pms.repositoty.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	@Override
	public String addProjectDetails(Project project) {

		projectRepository.save(project);
		
		return "Project Added Successfully";

	}

	@Override
	public String updateProjectDetails(long projectId, Project project) {

		Project existingProject = getProjectById(projectId);

		existingProject.setTitle(project.getTitle() != null ? project.getTitle() : existingProject.getTitle());
		existingProject.setBudget(project.getBudget() != null ? project.getBudget() : existingProject.getBudget());
		existingProject
				.setDuration(project.getDuration() != null ? project.getDuration() : existingProject.getDuration());
		existingProject.setEndDate(project.getEndDate() != null ? project.getEndDate() : existingProject.getEndDate());
		existingProject
				.setTeamSize(project.getTeamSize() != null ? project.getTeamSize() : existingProject.getTeamSize());
		existingProject.setManagerName(
				project.getManagerName() != null ? project.getManagerName() : existingProject.getManagerName());

		projectRepository.save(existingProject);

		return "Project Updated Successfully";
	}

	@Override
	public String deleteProjectDetails(long projectId) {

		Project existingProject = getProjectById(projectId);
		projectRepository.delete(existingProject);
		return "Project Deleted Successfully";
	}

	@Override
	public List<Project> listProjectDetails() {
		return projectRepository.findAll();
	}

	@Override
	public Project getProjectById(long projectId) throws ProjectNotFoundException {
		return projectRepository.findById(projectId)
				.orElseThrow(() -> new ProjectNotFoundException("Project not exist with id : " + projectId));
	}

}
