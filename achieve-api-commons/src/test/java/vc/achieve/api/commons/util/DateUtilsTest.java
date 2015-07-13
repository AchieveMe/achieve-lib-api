package vc.achieve.api.commons.util;

import java.util.Calendar;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import vc.achieve.api.commons.util.DateUtils;

/**
 * <p>Unit test class for {@link DateUtils}.</p>
 * 
 * @author Alberto Cerqueira
 * @since 1.0
 */
public class DateUtilsTest {
	
	private static Logger LOGGER = LoggerFactory.getLogger(DateUtilsTest.class);
	
	private String[] patterns = new String[]{"dd/MM/yyyy", "MM/dd/yyyy", "yyyy/MM/dd", "dd-MM-yyyy", "MM-dd-yyyy", "yyyy-MM-dd", "ddMMyyyy", "MMddyyyy", 
			"yyyyMMdd", "dd/MM/yyyy hh:mm:ss", "MM/dd/yyyy hh:mm:ss", "yyyy/MM/dd hh:mm:ss", "ddMMyyyy hh:mm:ss", "MMddyyyy hh:mm:ss", "yyyyMMdd hh:mm:ss"};
	
	private String date;
	
	@Test
	public void should_get_date_today_and_format_the_standard() {
		for (String pattern : patterns) {
			date = DateUtils.today(pattern);
			
			LOGGER.debug("The result was {} with the pattern {}", date, pattern);
		}
	}
	
	@Test
	public void should_get_calendar_to_string() {
		for (String pattern : patterns) {
			date = DateUtils.calendarToString(Calendar.getInstance(), pattern);
			
			LOGGER.debug("The result was {} with the pattern {}", date, pattern);
		}
	}
}