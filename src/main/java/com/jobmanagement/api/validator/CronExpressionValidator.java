/**
 * 
 */
package com.jobmanagement.api.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.quartz.CronExpression;

/**
 * @author Dheeraj Lalwani
 * This is validation class, to validate the cron expression for the newly registered job.
 */
public class CronExpressionValidator implements ConstraintValidator<ValidCronExpression, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value==null) {
			return true;
		} 
		return CronExpression.isValidExpression(value);
	}

}
