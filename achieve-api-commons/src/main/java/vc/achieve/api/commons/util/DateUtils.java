package vc.achieve.api.commons.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * <p> Util class to work with any <b>Date</b> or <b>Calendar</b>.</p>
 * <p>Class date utilitarian and recommended that this class be used when a Calendar object 
 * must be created for this strength class Locale for standard pt_BR this being used by the application.</p>
 * 
 * @author Alberto Cerqueira - <a href=˜mailto:alberto.cerqueira1990@gmail.com˜ />
 * @since 1.0
 */
public class DateUtils {
	
	private static DateUtils instance = new DateUtils();
	public static final String BRAZILIAN_PATTERN = "dd/MM/yyyy";
	public static final SimpleDateFormat completeTimer = new SimpleDateFormat("ss.SSSSSSZ");
	
	private DateUtils() {}
	public static DateUtils getInstance() {
		return instance;
	}
	
	/**
	 * <p>Returns a <b>Calendar</b> object</p>
	 * 
	 * @author Alberto Cerqueira
	 * @since 1.0
	 * @return <b>Calendar</b> with Locale pt_BR
	 */
	public static Calendar getCalendar() {
		return Calendar.getInstance(LocaleUtils.DEFAULT_LOCALE);
	}
	
	/**
	 * <p>Current date (today)</p>
	 * 
	 * @author Alberto Cerqueira
	 * @since 1.0
	 * @param pattern (String) desired pattern
	 * @return (String) date in string format with standard parameter
	 */
	public static String today(String pattern){
		return calendarToString(Calendar.getInstance(), pattern);
	}
	
	/**
	 * <p>Transforms the Date object to a string following the format defined in parameter pattern</p>
	 * 
	 * @author Alberto Cerqueira
	 * @since 1.0
	 * @param date (Calendar) date to be converted
	 * @param pattern (String) data output format
	 * @return (String) date in string format with standard parameter
	 */
	public static String calendarToString(Calendar date, String pattern) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat format = new SimpleDateFormat(pattern, LocaleUtils.DEFAULT_LOCALE);
		return format.format(date.getTime());
	}
	
    /**
     * <p>Transforms a date (Date) in String</p>
     * <p>Example pattern: <b>ddMMyyyy</b></p>
     * 
     * @author Alberto Cerqueira
	 * @since 1.0
     * @param date (Date) conversion date for
     * @param pattern (String) desired pattern
     * @return (String) date in string format with standard parameter
     */
    public static String dateToString(Date date, String pattern) {
        if (date == null) {
        	return "";        	
        }
        SimpleDateFormat format = new SimpleDateFormat(pattern, LocaleUtils.DEFAULT_LOCALE);
        return format.format(date);
    }
    
	/**
	 * <p>Converts the string informed in time, the string must have the format reported in pattern</p>
	 * 
	 * @author Alberto Cerqueira
	 * @since 1.0
	 * @param date (String) represents a date
	 * @param pattern (String) pattern in which the date is formatted
	 * @return (Calendar) date that was represented in the string
	 * @throws ParseException if the format is not compatible with the formatting of String
	 */
	public static Calendar stringToCalendar(String date, String pattern) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat(pattern, LocaleUtils.DEFAULT_LOCALE);
		Date d = format.parse(date);
		Calendar c = getCalendar();
		c.setTime(d);
		return c;
	}
	
	/**
	 * <p>Create a Date object from a String and a standard</p>
     * <p>Example pattern: <b>ddMMyyyy</b></p>
     * 
     * @author Alberto Cerqueira
	 * @since 1.0
     * @param date (String) date to be created
     * @param pattern (String) pattern in which the date is formatted
     * @return (Date) date that was represented in the string
     * @throws ParseException if an error occurs
     */
    public static Date stringToDate(String date, String pattern) throws ParseException {
        if (date.length() == 7) {
            date = "0" + date;
        }
        SimpleDateFormat format = new SimpleDateFormat(pattern, LocaleUtils.DEFAULT_LOCALE);
        return format.parse(date);
    }
	
	/**
	 * <p>Returns an Integer in <b>yyyyMMdd</b> the calendar entered as parameter format</p>
	 * 
	 * @author Alberto Cerqueira
	 * @since 1.0
	 * @param date (Calendar) date to be processed into Integer
	 * @return (Integer) representing the date, or null if the parameter is null
	 */
	public static Integer calendarToInteger(Calendar date) {
		if (date != null) {
			return Integer.valueOf(date.get(Calendar.YEAR) + "" + StringUtils.leftPad("" + (date.get(Calendar.MONTH) + 1), "0", 2) + "" + StringUtils.leftPad("" + date.get(Calendar.DAY_OF_MONTH), "0", 2));
		}
		return null;
	}
	
	/**
	 * <p>Returns an Integer in <b>HHmmss</b> the calendar entered as parameter format</p>
	 * 
	 * @author Alberto Cerqueira
	 * @since 1.0
	 * @param date (Calendar) date which will have its time turned into Integer
	 * @return (Integer) representing the date, or null if the parameter is null
	 */
	public static Integer calendarToIntegerHora(Calendar data) {
		if (data != null) {
			SimpleDateFormat format = new SimpleDateFormat("HHmmss", LocaleUtils.DEFAULT_LOCALE);
			String hora =  format.format(data.getTime());
			return Integer.valueOf(hora);
		}
		return Integer.valueOf(0);
	}
	
	/**
	 * <p>Returns an Integer in <b>yyyyMMdd</b> shape of the given string as a parameter</p>
	 * 
	 * @author Alberto Cerqueira
	 * @since 1.0
	 * @param date (Calendar) date to be processed into Integer
	 * @param pattern (String) pattern in which the date is formatted
	 * @return (Integer) representing the date, or null if the parameter is null
	 */
	public static Integer stringToInteger(String date, String pattern) throws ParseException {
		Calendar c = stringToCalendar(date, pattern);
		return calendarToInteger(c);
	}
	
	/**
	 * <p>Returns an Integer in HHmmss informed of string as a parameter format</p>
	 * 
	 * @author Alberto Cerqueira
	 * @since 1.0
	 * @param date (Calendar) date to be processed into Integer
	 * @param pattern (String) pattern in which the date is formatted
	 * @return (Integer) representing the time, or null if the parameter is null
	 */
	public static Integer stringToIntegerHora(String date, String pattern) throws ParseException {
		Calendar c = stringToCalendar(date, pattern);
		return calendarToIntegerHora(c);
	}
}