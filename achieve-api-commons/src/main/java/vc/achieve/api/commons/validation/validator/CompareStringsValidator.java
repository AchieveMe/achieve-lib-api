package vc.achieve.api.commons.validation.validator;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintValidatorContext.ConstraintViolationBuilder;

import vc.achieve.api.commons.enumtype.StringComparisonMode;
import vc.achieve.api.commons.validation.CompareValues;
import vc.achieve.api.commons.validation.constraint.ConstraintValidatorHelper;

/**
 * @author GAN
 *
 */
public class CompareStringsValidator implements ConstraintValidator<CompareValues, Object> {
	
	private String[] propertyNames;
    private StringComparisonMode comparisonMode;
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
        int validationFailedAtIndex = -1;
        for (int i = 0; i < propertyNames.length; i++) {
            //explode
            List<String> propertyValues = new ArrayList<String> (propertyNames.length);
            String[] valueIdentifiers = propertyNames[i].split(",");
            for (int j = 0; j < valueIdentifiers.length; j++) {
                Object propertyValue = ConstraintValidatorHelper.getPropertyValue(String.class, valueIdentifiers[j], target);
                if (propertyValue == null) {
                    if (!allowNull) {
                        isValid = false;
                        validationFailedAtIndex = i;
                        break;
                    }
                } else {
                    propertyValues.add((String) propertyValue);
                }
            }

            if (isValid) {
                isValid = ConstraintValidatorHelper.isValid(propertyValues, comparisonMode);
                if (!isValid) {
                    validationFailedAtIndex = i;
                }
            } else {
                break;
            }
        }

        if (!isValid) {
            boolean isDefaultMessage = "".equals(context.getDefaultConstraintMessageTemplate());
            /* if custom message was provided, don't touch it, otherwise build the default message */
            if (isDefaultMessage) {
                String resolvedMessage = ConstraintValidatorHelper.resolveMessage(propertyNames[validationFailedAtIndex].split(","), comparisonMode);
                context.disableDefaultConstraintViolation();
                ConstraintViolationBuilder violationBuilder = context.buildConstraintViolationWithTemplate(resolvedMessage);
                violationBuilder.addConstraintViolation();
            }
        }
        return isValid;
    }
}