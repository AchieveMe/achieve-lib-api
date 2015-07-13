package vc.achieve.api.commons.util;

import java.util.Date;

/**
 * <p> Util class to work with any <b>Integer</b>.</p>
 * 
 * @author Alberto Cerqueira - <a href=˜mailto:alberto.cerqueira1990@gmail.com˜ />
 * @since 1.0
 */
public class IntegerUtils {

	private static IntegerUtils instance = new IntegerUtils();
	
	private IntegerUtils(){}
	public static IntegerUtils getInstance(){
		return instance;
	}
	
	/**
	 * <p>Checks if the String contains only numbers</p>
	 * 
	 * @author Alberto Cerqueira
	 * @since 1.0
	 * @param str (String) string to check
	 * @return (boolean) true if the String has only numbers and false otherwise
	 */
	public static boolean isOnlyNumber(String value) {
		boolean ret = false;
		if (!StringUtils.isBlank(value)) {
			ret = value.matches("^[0-9]+$");
		}
		return ret;
	}
	
	/**
	 * <p>Check if the String is empty</p>
	 * <p>
	 * 		Examples: 
	 * 		<ul>
	 * 	 		<li><code>" " == false</code></li>
	 * 	 		<li><code>"" == true</code></li>
	 *   		<li><code>"0" == true</code></li>
	 *   		<li><code>"1" == false</code></li>
	 * 		</ul>
	 * </p>
	 * 
	 * @author Alberto Cerqueira
	 * @since 1.0
	 * @param value (String) value for verification
	 * @return (boolean) true to empty string and false otherwise
	 * @see vc.achieve.api.commons.StringUtils.isBlank(String)
	 */
	public static boolean isBlank(String value) {
		boolean isBlank = StringUtils.isBlank(value);
		if (!isBlank) {
			if (isOnlyNumber(value)) {
				isBlank = (Integer.valueOf(value).intValue() == 0);
			}
		}
		return isBlank;
	}
	
	/**
	 * <p>Converting Number of int</p>
	 * 
	 * @author Alberto Cerqueira
	 * @since 1.0
	 * @param value (Number) to converting
	 * @return (int) Number of value in the int format
	 */
    public static int parseInt(Number value) {
        if (value != null) {
            return value.intValue();
        }
        return 0;
    }

    /**
     * <p>Converts String into int if the value contains only numbers</p>
     * 
     * @author Alberto Cerqueira
	 * @since 1.0
     * @param value (String) to converting
     * @return (int) String value of the int format or 0 (zero) if isOnlyNumber() equals false
     */
    public static int parseInt(String value) {
        if (!StringUtils.isBlank(value) && isOnlyNumber(value)) {
            return Integer.parseInt(value.trim());
        }
        return 0;
    }

    /**
     * <p>Transforms a date (Date) Integer in the desired format</p>
     * 
     * @author Alberto Cerqueira
	 * @since 1.0
     * @param date (Date) to converting
     * @param pattern (String) desired pattern
     * @return (int) representing the date, or null if the parameter is null
     */
    public static int parseInt(Date data, String pattern) {
        int ret = 0;
        if (data != null) {
			String strData = DateUtils.dateToString(data, pattern);
            ret = parseInt(strData);
        }
        return ret;
    }
    
    /**
     * <p>Transforms a date (Date) Integer in the <b>yyyyMMdd</b> format</p>
     * 
     * @author Alberto Cerqueira
	 * @since 1.0
     * @param date (Date) to converting
     * @return (int) representing the date, or null if the parameter is null
     * @see vc.achieve.api.commons.IntegerUtils.parseInt(Date, String)
     */
    public static int parseInt(Date data) {
    	return parseInt(data, "yyyyMMdd");
    }
}