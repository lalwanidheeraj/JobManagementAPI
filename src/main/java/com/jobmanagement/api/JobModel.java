/**
 * 
 */
package com.jobmanagement.api;

import javax.validation.constraints.NotNull;

import com.jobmanagement.api.validator.ValidCronExpression;

/**
 * @author Dheeraj Lalwani
 * This is the model class for the Job management project.
 */
public class JobModel {
	
	@NotNull(message="{invalid.job.name}")
	private String jobName;
	@NotNull(message="{invalid.job.priority}")
	private Integer priority;
	@NotNull(message="{invalid.job.url}")
	private String jobUrl;
	@NotNull(message="{blank.cron.expression}")
	@ValidCronExpression
	private String cronExpression;
	
	private String jobStatus;
	
	public JobModel() {}
	
	public JobModel(String jobName, Integer priority, String jobUrl, String cronExpression) {
		super();
		this.jobName = jobName;
		this.priority = priority;
		this.jobUrl = jobUrl;
		this.cronExpression = cronExpression;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public String getJobUrl() {
		return jobUrl;
	}
	public void setJobUrl(String jobUrl) {
		this.jobUrl = jobUrl;
	}
	public String getCronExpression() {
		return cronExpression;
	}
	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}
	public String getJobStatus() {
		return jobStatus;
	}
	public void setJobStatus(String jobStatus) {
		this.jobStatus = jobStatus;
	}
}
