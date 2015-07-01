package vc.achieve.api.commons;

import java.util.UUID;

/**
 * <p> Util class to work with any <b>UUID</b>.</p>
 * 
 * @author Alberto Cerqueira - <a href=˜mailto:alberto.cerqueira1990@gmail.com˜ />
 * @since 1.0
 */
public class UUIDUtils {

	private UUIDUtils() {
        throw new AssertionError();
    }
	
	/**
	 * <p>UUID generator random</p>
	 * 
	 * @author Alberto Cerqueira
	 * @since 1.0
	 * @return (String) string UUID random
	 */
	public static String generateUUID() {
		return UUID.randomUUID().getLeastSignificantBits() + "";
	}
}