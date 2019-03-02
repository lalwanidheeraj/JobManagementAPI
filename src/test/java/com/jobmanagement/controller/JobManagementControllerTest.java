package com.jobmanagement.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.jobmanagement.api.JobModel;
import com.jobmanagement.service.JobManagementService;

/**
 * @author Dheeraj Lalwani
 * This is test class for JobManagementController.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(JobManagementController.class)
public class JobManagementControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private JobManagementService jobManagementService;
	
	@Test
	public void testJobList() throws Exception {
		JobModel exportJob = new JobModel("Export Job",2,"http://localhost:8443/executeExport","7 * * * * ?");
		Collection<JobModel> jobList = new ArrayList<JobModel>();
		jobList.add(exportJob);
		when(jobManagementService.jobList()).thenReturn(jobList);
		mockMvc.perform(get("/jobList")).andExpect(status().isOk())
		.andExpect(jsonPath("$", hasSize(1)));
	}
	@Test
	public void testExecuteAllJobs() throws Exception {
		mockMvc.perform(get("/executeAllJobs")).andExpect(status().isOk());
	}
	@Test
	public void testRegisterJobForSuccess() throws Exception {
		String json="{\"cronExpression\":\"5 * * * * ?\" ,\"jobName\": \"test job\",\"priority\": 3 ,\"jobUrl\": \"http://test.job\"}";
		mockMvc.perform(post("/registerJob").contentType(MediaType.APPLICATION_JSON).content(json))
		.andExpect(status().isOk());
	}
}
