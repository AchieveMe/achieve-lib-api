package vc.achieve.api.commons.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import vc.achieve.api.commons.validation.enumtype.ComparisonMode;
import vc.achieve.api.commons.validation.validator.CompareValidator;

/**
 * <p>Annotation that makes the comparison between
 * the values that is passed in the <code>propertyNames</code>
 * and add this validation, acting as a bean validation.</p>
 * 
 * @author GAN - <a href=˜mailto:guiandmag@gmail.com˜ />
 * @author Alberto Cerqueira - <a href=˜mailto:alberto.cerqueira1990@gmail.com˜ />
 * @since 1.0
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=CompareValidator.class)
@Documented
public @interface CompareValues {
	
	/**
	 * <p>Property that will be passed
	 * through the method.</p>
	 * 
	 * @return Array
	 */
    String[] propertyNames();
    
    /**
     * <p>Comparison mode that will be
     * passed to run the comparison.</p>
     * 
     * @return ComparisonMode
     */
    ComparisonMode matchMode() default ComparisonMode.EQUAL;
    
    /**
     * <p>Allow null levels in the 
     * annotations to match any value.</p>
     * 
     * @return boolean
     */
    boolean allowNull() default false;
    
    /**
     * <p>The message that will be passed
     * to the annotation to make the assertion.</p>
     * 
     * @return String
     */
    String message() default "";
    
    /**
     * <p>Pass the groups of classes
     * that is being passed.</p>
     * 
     * @return Class
     */
    Class<?>[] groups() default {};
    
    /**
     * <p>Payload of the annotation.</p>
     * 
     * @return Class
     */
    Class<? extends Payload>[] payload() default {};
    
}