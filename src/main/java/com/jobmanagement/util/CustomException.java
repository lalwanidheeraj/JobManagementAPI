package com.jobmanagement.util;

/**
 * @author Dheeraj Lalwani
 * This is custom exception class for the job management project.
 */
public class CustomException extends Exception{

	private static final long serialVersionUID = 1L;

	public CustomException() {
		super();
	}

	public CustomException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public CustomException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public CustomException(String arg0) {
		super(arg0);
	}

	public CustomException(Throwable arg0) {
		super(arg0);
	}
}
