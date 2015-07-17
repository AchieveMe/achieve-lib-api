package vc.achieve.api.commons.validation.validator;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintValidatorContext.ConstraintViolationBuilder;

import vc.achieve.api.commons.validation.CompareValues;
import vc.achieve.api.commons.validation.constraint.ConstraintValidatorHelper;
import vc.achieve.api.commons.validation.enumtype.ComparisonMode;

/**
 * <p>Validator for our values.</p>
 * 
 * @author GAN
 * @author Alberto Cerqueira
 * @since 1.0
 */
public class CompareStringsValidator implements ConstraintValidator<CompareValues, Object> {
	
	private String[] propertyNames;
    private ComparisonMode comparisonMode;
    private boolean allowNull;

    @Override
    public void initialize(CompareValues constraintAnnotation) {
        this.propertyNames = constraintAnnotation.propertyNames();
        this.comparisonMode = constraintAnnotation.matchMode();
        this.allowNull = constraintAnnotation.allowNull();
    }

    @Override
    public boolean isValid(Object target, ConstraintValidatorContext context) {
    	boolean isValid = true;
        List<String> propertyValues = new ArrayList<String> (propertyNames.length);
        for (int i = 0, l = propertyNames.length; i < l; i++) {
            String propertyValue = ConstraintValidatorHelper.getPropertyValue(String.class, propertyNames[i], target);
            if (propertyValue == null) {
                if (!allowNull) {
                    isValid = false;
                    break;
                }
            } else {
                propertyValues.add(propertyValue);
            }
        }

        if (isValid) {
            isValid = ConstraintValidatorHelper.isValid(propertyValues, comparisonMode);
        }

        if (!isValid) {
        	boolean isDefaultMessage = "".equals(context.getDefaultConstraintMessageTemplate());
            
            if (isDefaultMessage) {
            	String resolvedMessage = ConstraintValidatorHelper.resolveMessage(propertyNames, comparisonMode);
                context.disableDefaultConstraintViolation();
                ConstraintViolationBuilder violationBuilder = context.buildConstraintViolationWithTemplate(resolvedMessage);
                violationBuilder.addConstraintViolation();
            }
        }
        return isValid;
    }
}