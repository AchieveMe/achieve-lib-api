package vc.achieve.api.commons.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import vc.achieve.api.commons.validation.enumtype.ComparisonMode;
import vc.achieve.api.commons.validation.validator.CompareStringsValidator;

/**
 * <p>Annotation that makes the comparison between
 * the values that is passed in the <code>propertyNames</code>
 * and add this validation, acting as a bean validation.</p>
 * 
 * @author GAN - <a href=˜mailto:guiandmag@gmail.com˜ />
 * @since 1.0
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=CompareStringsValidator.class)
@Documented
public @interface CompareValues {
	
    String[] propertyNames();
    
    ComparisonMode matchMode() default ComparisonMode.EQUAL;
    
    boolean allowNull() default false;
    
    String message() default "";
    
    Class<?>[] groups() default {};
    
    Class<? extends Payload>[] payload() default {};
    
}