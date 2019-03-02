/**
 * 
 */
package com.jobmanagement.util;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import com.jobmanagement.api.JobModel;

/**
 * @author Dheeraj Lalwani
 * This class loads the job at startup also register the jobs for scheduling.
 */
@Component
public class JobRegistrar {
	
	@Autowired
    private ApplicationContext applicationContext;
	
	@Autowired
	private TaskScheduler taskScheduler;
	
	@PostConstruct
	private void initialize() {
		populateJobData();
		scheduleAllTasks();
	}
	/**
	 * This is the method, which populates the test jobs in the map.
	 */
	private void populateJobData() {
		JobModel importJob = new JobModel("Import Job",1,"http://localhost:8443/executeImport","5 * * * * ?");
		JobModel exportJob = new JobModel("Export Job",2,"http://localhost:8443/executeExport","7 * * * * ?");
		JobRepository.jobs.put(importJob.getJobUrl(), importJob);
		JobRepository.jobs.put(exportJob.getJobUrl(), exportJob);
	}
	/**
	 * This method schedule all the jobs.
	 */
	private void scheduleAllTasks() {
		for(JobModel job : JobRepository.jobs.values()) {
			scheduleTask(job);
		}
	}
	/**
	 * This method schedule the supplied job.
	 * @param job
	 */
	public void scheduleTask(JobModel job) {
		JobExecutor executor = applicationContext.getBean(JobExecutor.class);
		executor.setJobModel(job);
		taskScheduler.schedule(executor, new CronTrigger(job.getCronExpression()));
	}
}
