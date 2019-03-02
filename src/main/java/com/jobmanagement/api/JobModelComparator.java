/**
 * 
 */
package com.jobmanagement.api;

import java.util.Comparator;

/**
 * @author Dheeraj Lalwani
 * This is the comparator class for JobModel.
 */
public class JobModelComparator implements Comparator<JobModel>{

	@Override
	public int compare(JobModel o1, JobModel o2) {
		int sort = o1.getPriority().compareTo(o2.getPriority());
		if(sort!=0) {
			return sort;
		}
		return o1.getJobName().compareTo(o2.getJobName());
	}

}
