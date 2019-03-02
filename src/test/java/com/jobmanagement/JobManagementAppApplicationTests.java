package com.jobmanagement;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jobmanagement.controller.JobManagementController;

/**
 * @author Dheeraj Lalwani
 * This is spring boot application class for job management application.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JobManagementAppApplicationTests {
	
	@Autowired
	private JobManagementController controller;
	
	@Test
	public void contextLoads() {
		assertNotNull(controller);
	}

}
