package vc.achieve.api.commons.generator.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import vc.achieve.api.commons.generator.Generator;

/**
 * <p> Util class that generates random <b>Passwords</b>.</p>
 * 
 * @author Alberto Cerqueira - <a href=˜mailto:alberto.cerqueira1990@gmail.com˜ />
 * @since 1.0
 */
public class PasswordGenerator implements Generator {
	
	private static Logger LOGGER = LoggerFactory.getLogger(PasswordGenerator.class);
	
	/**
	 * <p>Private field to hold the unique instance of the object.</p>
	 * 
	 * @author GAN
	 * @since 1.0
	 */
    private static final PasswordGenerator INSTANCE = new PasswordGenerator();
    
    /**
	 * <h2>Singleton Patterns</h2>
	 * 
	 * <p>Utility class, there is no need to be instantiated. Prevent to be created at reflection
	 * a second CPFGenerator at runtime.</p>
	 * 
	 * @author GAN
	 * @since 1.0
	 */
    private PasswordGenerator() {
    	if (PasswordGenerator.INSTANCE != null) {
    		LOGGER.error("Already instantiated {}", new IllegalStateException());
    	}
    }
    
    /**
	 * <p>Method that will return the instance of the object.</p>
	 * 
	 * @author GAN
	 * @since 1.0
	 * @return Object Instance 
	 */
    public static PasswordGenerator getInstance() {
    	LOGGER.debug("{} was already instantiated", PasswordGenerator.class.getName());
    	
    	return PasswordGenerator.INSTANCE;
    }
	
	/**
	 * <p>Replacement of char in the <code>String</code></p>
	 *
	 * @author GAN
	 * @param c
	 * @return String formatted 
	 */
	public static String replaceChar(String c) {
		if (c.equalsIgnoreCase("a")) {
			return "@";
		} else if (c.equalsIgnoreCase("e")) {
			return "&";
		} else if (c.equalsIgnoreCase("i")) {
			return "1";
		} else if (c.equalsIgnoreCase("s")) {
			return "$";
		} else if (c.equalsIgnoreCase("x")) {
			return "%";
		} else if (c.equalsIgnoreCase("b")) {
			return "#";
		} else if (c.equalsIgnoreCase("o")) {
			return "0";
		} else {
			return c;
		}
	}

}