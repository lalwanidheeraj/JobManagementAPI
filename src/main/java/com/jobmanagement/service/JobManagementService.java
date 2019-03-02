package com.jobmanagement.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jobmanagement.api.JobModel;
import com.jobmanagement.api.JobModelComparator;
import com.jobmanagement.util.CustomException;
import com.jobmanagement.util.JobRegistrar;
import com.jobmanagement.util.JobRepository;

/**
 * @author Dheeraj Lalwani
 * This is the service class for the job management apis.
 */
@Component
public class JobManagementService {
	
	@Autowired
	private JobRegistrar jobRegistrar;
	
	Logger _logger = Logger.getLogger(JobManagementService.class.getName());

	/**
	 * This is service method, which lists all the jobs.
	 * @return
	 */
	public Collection<JobModel> jobList() {
		return JobRepository.jobs.values();
	}
	
	/**
	 * This is service method to register new job.
	 * @param jobModel
	 * @throws Exception
	 */
	public void registerJob(JobModel jobModel) throws Exception {
		if(JobRepository.jobs.get(jobModel.getJobUrl())!=null) {
			throw new CustomException("Job already exists with the same action.");
		} 
		JobRepository.jobs.put(jobModel.getJobUrl(), jobModel);
		jobRegistrar.scheduleTask(jobModel);
	}
	
	/**
	 * This is service method to execute all jobs based on their priority.
	 */
	public void executeAllJobs() {
		List<JobModel> jobs = new ArrayList<JobModel>(jobList());
		Collections.sort(jobs,new JobModelComparator());
		for(JobModel jobModel : jobs){
			_logger.log(Level.INFO, "Queued Job"+jobModel.getJobName());
			jobModel.setJobStatus("Queued");
			executeJob(jobModel);
		}
	}
	/**
	 * This is service method, which executes the supplied job.
	 * @param job
	 */
	public void executeJob(JobModel job)  {
		_logger.log(Level.INFO, "Starting Job"+job.getJobName());
		job.setJobStatus("Started");
		
		// TODO - This will be replaced with RestTemplate call.
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			_logger.log(Level.SEVERE, "Job Execution Failed"+job.getJobName());
			job.setJobStatus("Failed");
		}
		_logger.log(Level.INFO, "Finishing Job"+job.getJobName());
		job.setJobStatus("Completed");
	}
}
