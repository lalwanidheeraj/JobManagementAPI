package com.jobmanagement.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.jobmanagement.api.JobModel;
import com.jobmanagement.service.JobManagementService;

/**
 * @author Dheeraj Lalwani
 *  This is job executor class to execute the jobs.
 */
@Component
@Scope("prototype")
public class JobExecutor implements Runnable{
	
	@Autowired
	private JobManagementService jobManagementService;
	
	private JobModel jobModel;

	@Override
	public void run() {
		jobManagementService.executeJob(jobModel);
	}

	public void setJobModel(JobModel jobModel) {
		this.jobModel = jobModel;
	}
}
