package com.jobmanagement.controller;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jobmanagement.api.JobModel;
import com.jobmanagement.service.JobManagementService;

/**
 * @author Dheeraj Lalwani
 * This is controller class for the job management api.
 */
@RestController
public class JobManagementController {
	
	@Autowired
	private JobManagementService jobManagementService;
	
	/**
	 * This is rest endpoint, which lists all the jobs.
	 * @return
	 */
	@RequestMapping(value="/jobList",method=RequestMethod.GET)
	private Collection<JobModel> jobList() {
		return jobManagementService.jobList();
	}
	
	/**
	 * This is rest endpoint, which registers the supplied job.
	 * @param jobModel
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/registerJob",method=RequestMethod.POST) 
	private ResponseEntity<String> registerJob(@Valid @RequestBody JobModel jobModel,Errors errors) throws Exception {
		if (errors.hasErrors()) {
	        return new ResponseEntity<String>(errors.getFieldError().getDefaultMessage(),HttpStatus.BAD_REQUEST);
	    }
		jobManagementService.registerJob(jobModel);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	/**
	 * This is rest endpoint, which executes all the registered jobs.
	 * @return
	 */
	@RequestMapping(value="/executeAllJobs",method=RequestMethod.GET) 
	private HttpStatus executeAllJobs() {
		jobManagementService.executeAllJobs();
		return HttpStatus.OK;
	}
}
