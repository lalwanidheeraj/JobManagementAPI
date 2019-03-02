/**
 * 
 */
package com.jobmanagement.api.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * @author Dheeraj Lalwani
 * This is custom validation annotation to validate the input cron expression.
 */
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CronExpressionValidator.class)
public @interface ValidCronExpression {
	String message() default "{invalid.cron.expression}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
