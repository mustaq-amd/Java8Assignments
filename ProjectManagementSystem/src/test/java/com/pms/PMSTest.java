package com.pms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

import java.sql.Date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.pms.entity.Project;
import com.pms.repositoty.ProjectRepository;
import com.pms.service.ProjectService;

@SpringBootTest
@DisplayName("Unit Testing PMS")
public class PMSTest {

	@Autowired
	private ProjectService projectService;

	@Autowired
	@MockBean
	ProjectRepository projectRepository;

	

	@Test
	@DisplayName("Add Project Test")
	void addProjectDetailsTest() {

		Project project = new Project();

		project.setTitle("Ecommerce Web App");
		project.setBudget(4600000.00);
		project.setDuration(200);
		project.setEndDate(new Date(2022, 10, 14));
		project.setTeamSize(40);
		project.setManagerName("Mustaq");

		assertEquals("Project Added Successfully", projectService.addProjectDetails(project));

	}

	@Test
	@DisplayName("Update Project Test")
	void updateProjectDetails() {

		Project project = new Project();
		project.setTeamSize(15);

		assertEquals("Project Updated Successfully", projectService.updateProjectDetails(4, project));

	}

	@Test
	@DisplayName("Delete Project Test")
	void deleteProjectDetails() {
		
		assertEquals("Project Deleted Successfully", projectService.deleteProjectDetails(3));
		
	}

	@Test
	@DisplayName("List Project Details Test")
	void listProjectDetailsTest() {

		projectService.listProjectDetails();
		verify(projectRepository).findAll();

	}

}
