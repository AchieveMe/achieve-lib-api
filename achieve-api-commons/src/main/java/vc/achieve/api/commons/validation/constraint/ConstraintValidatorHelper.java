package vc.achieve.api.commons.validation.constraint;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import vc.achieve.api.commons.validation.enumtype.ComparisonMode;

/**
 * <p>Helper to validate the messages that come
 * out from the property values.</p>
 * 
 * @author GAN
 * @since 1.0
 */
public abstract class ConstraintValidatorHelper {
	
	private static Logger LOGGER = LoggerFactory.getLogger(ConstraintValidatorHelper.class);
	
	/**
	 * <p>Get the property of the value, and
	 * threat the kind of the object.</p>
	 * 
	 * @param requiredType
	 * @param propertyName
	 * @param instance
	 * @return
	 */
	public static <T> T getPropertyValue(Class<T> requiredType, String propertyName, Object instance) {
		Objects.requireNonNull(requiredType, "Invalid argument. requiredType must NOT be null!");
		Objects.requireNonNull(propertyName, "Invalid argument. PropertyName must NOT be null!");
		Objects.requireNonNull(instance, "Invalid argument. Object instance must NOT be null!");
		
        T returnValue = null;
        
        try {
            PropertyDescriptor descriptor = new PropertyDescriptor(propertyName, instance.getClass());
            Method readMethod = descriptor.getReadMethod();
            
            Objects.requireNonNull(readMethod, "Property '" + propertyName + "' of " + instance.getClass().getName() + " is NOT readable!");
            
            if (requiredType.isAssignableFrom(readMethod.getReturnType())) {
                Object propertyValue = readMethod.invoke(instance);
                returnValue = requiredType.cast(propertyValue);
            }
            
        } catch (IntrospectionException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
        	LOGGER.error("Property '{}' is NOT defined in {} !", propertyName, instance.getClass().getName());
            LOGGER.error(e.getMessage());
        }
        
        return returnValue; 
    }

	/**
	 * <p>Check the values and validate
	 * if it is valid or not.</p>
	 * 
	 * @param propertyValues
	 * @param comparisonMode
	 * @return
	 */
    public static boolean isValid(Collection<String> propertyValues, ComparisonMode comparisonMode) {
        boolean ignoreCase = false;
        switch (comparisonMode) {
        	case EQUAL_IGNORE_CASE:
        	case NOT_EQUAL_IGNORE_CASE:
        		ignoreCase = true;
        	default:
        		ignoreCase = false;
        }

        List<String> values = new ArrayList<> (propertyValues.size());
        
        for (String propertyValue : propertyValues) {
            if (ignoreCase) {
                values.add(propertyValue.toLowerCase());
            } else {
                values.add(propertyValue);
            }
        }

        switch (comparisonMode) {
        	case EQUAL:
        	case EQUAL_IGNORE_CASE:
                Set<String> uniqueValues = new HashSet<String> (values);
                return uniqueValues.size() == 1 ? true : false;
            case NOT_EQUAL:
            case NOT_EQUAL_IGNORE_CASE:
                Set<String> allValues = new HashSet<String> (values);
                return allValues.size() == values.size() ? true : false;
        }

        return true;
    }

    /**
     * <p>Resolve the common message that
     * will be printed when the annotation is 
     * used.</p>
     * 
     * @param propertyNames
     * @param comparisonMode
     * @return
     */
    public static String resolveMessage(String[] propertyNames, ComparisonMode comparisonMode) {
        StringBuffer sb = concatPropertyNames(propertyNames);
        sb.append(" must");
        
        switch(comparisonMode) {
	        case EQUAL:
	        case EQUAL_IGNORE_CASE:
	        	sb.append(" be equal");
	            break;
	        case NOT_EQUAL:
	        case NOT_EQUAL_IGNORE_CASE:
	        	sb.append(" not be equal");
	            break;
        }
        
        sb.append('.');
        
        return sb.toString();
    }

    private static StringBuffer concatPropertyNames(String[] propertyNames) {
        StringBuffer sb = new StringBuffer();
        sb.append('[');
        
        for(String propertyName : propertyNames) {
            char firstChar = Character.toUpperCase(propertyName.charAt(0));
            sb.append(firstChar);
            sb.append(propertyName.substring(1));
            sb.append(", ");
        }
        
        sb.delete(sb.length()-2, sb.length());
        sb.append("]");
        
        return sb;
    }
}