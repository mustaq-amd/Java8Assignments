package com.pms;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.pms.entity.Project;

@SpringBootTest
class ProjectManagementSystemApplicationTests {

	private static final Log LOGGER = LogFactory.getLog(ProjectManagementSystemApplicationTests.class);

	private static final String GET_ALL_PROJECTS_URL = "http://localhost:8080/projects";
	private static final String ADD_PROJECTS_URL = "http://localhost:8080/projects";
	private static final String UPDATE_PROJECTS_URL = "http://localhost:8080/projects/{projectId}";
	private static final String DELETE_PROJECTS_URL = "http://localhost:8080/projects/{projectId}";

	RestTemplate restTemplate = new RestTemplate();

	@Test
	void contextLoads() {
	}

	public static void main(String[] args) {

		ProjectManagementSystemApplicationTests test = new ProjectManagementSystemApplicationTests();

		List<Project> listOfProjects = test.getAllProjectsTest();

		listOfProjects.forEach(System.out::println);
		
		/*
		Project project = new Project();
		
		project.setTitle("Ecommerce Web App");
		project.setBudget(4600000.00);
		project.setDuration(200);
		project.setEndDate(new Date(2022, 10, 14));
		project.setTeamSize(40);
		project.setManagerName("Mustaq");
		
		test.addProjectDetailsTest(project);
		
		*/
		
		/*
		Project updateProject = new Project();
		updateProject.setManagerName("Aruna");
		
		
		test.updateProjectDetailsTest(1, updateProject);
		*/
	
		
		
		//test.deleteProjectDetailsTest(2);
	}

	public List<Project> getAllProjectsTest() {

		List<Project> list = new ArrayList<>();

		Project[] projects = restTemplate.getForObject(GET_ALL_PROJECTS_URL, Project[].class);

		for (Project p : projects) {
			list.add(p);
		}

		return list;

	}

	public void addProjectDetailsTest(Project project) {

		String response = restTemplate.postForObject(ADD_PROJECTS_URL, project, String.class);

		LOGGER.info(response);

	}

	public void updateProjectDetailsTest(long projectId, Project project) {

		restTemplate.put(UPDATE_PROJECTS_URL, project, projectId);

		LOGGER.info("Project Updated Successfullyy...");

	}

	public void deleteProjectDetailsTest(long projectId) {

		restTemplate.delete(DELETE_PROJECTS_URL, projectId);

		LOGGER.info("Project Deleted Successfullyy...");

	}

}
