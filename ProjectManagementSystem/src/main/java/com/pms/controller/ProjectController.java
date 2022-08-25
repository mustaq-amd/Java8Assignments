package com.pms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pms.entity.Project;
import com.pms.service.ProjectService;

@RestController
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	@GetMapping("/projects")
	public ResponseEntity<List<Project>> getAllProjectDetails() {

		return new ResponseEntity<List<Project>>(projectService.listProjectDetails(), HttpStatus.OK);

	}

	@PostMapping("/projects")
	public ResponseEntity<String> addProjectDetails(@Valid @RequestBody Project project) {

		return new ResponseEntity<String>(projectService.addProjectDetails(project), HttpStatus.CREATED);
	}

	@PutMapping("/projects/{projectId}")
	public ResponseEntity<String> updateProjectDetails(@PathVariable long projectId, @Valid @RequestBody Project project) {

		return new ResponseEntity<String>(projectService.updateProjectDetails(projectId, project), HttpStatus.OK);
	}

	@DeleteMapping("/projects/{projectId}")
	public ResponseEntity<String> deleteProjectDetails(@PathVariable long projectId) {

		return new ResponseEntity<String>(projectService.deleteProjectDetails(projectId), HttpStatus.OK);
	}

}
