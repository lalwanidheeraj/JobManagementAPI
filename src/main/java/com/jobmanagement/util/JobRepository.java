package com.jobmanagement.util;

import java.util.HashMap;
import java.util.Map;

import com.jobmanagement.api.JobModel;

/**
 * @author Dheeraj Lalwani
 * This class holds the static map, which caches the job data.
 */
public class JobRepository {
	
	public static final Map<String, JobModel> jobs = new HashMap<String, JobModel>();
}
