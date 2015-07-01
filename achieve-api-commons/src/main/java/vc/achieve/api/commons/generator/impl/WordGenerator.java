package vc.achieve.api.commons.generator.impl;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import vc.achieve.api.commons.generator.Generator;

/**
 * <p> Util class that generates random <b>Strings</b> and <b>Words</b>.</p>
 * 
 * @author Alberto Cerqueira - <a href=˜mailto:alberto.cerqueira1990@gmail.com˜ />
 * @since 1.0
 */
public class WordGenerator implements Generator {
	
	private static Logger LOGGER = LoggerFactory.getLogger(WordGenerator.class);
	
	/**
	 * <p>Private field to hold the unique instance of the object.</p>
	 * 
	 * @author GAN
	 * @since 1.0
	 */
    private static final WordGenerator INSTANCE = new WordGenerator();
    
    /**
	 * <h2>Singleton Patterns</h2>
	 * 
	 * <p>Utility class, there is no need to be instantiated. Prevent to be created at reflection
	 * a second CPFGenerator at runtime.</p>
	 * 
	 * @author GAN
	 * @since 1.0
	 */
    private WordGenerator() {
    	if (WordGenerator.INSTANCE != null) {
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
    public static WordGenerator getInstance() {
    	LOGGER.debug("{} was already instantiated", WordGenerator.class.getName());
    	
    	return WordGenerator.INSTANCE;
    }
	
	/**
	 * <p>Appender for the letters that was
	 * passed by.</p>
	 * 
	 * @author GAN
	 * @since 1.0
	 * @param letter
	 * @param maxChar
	 * @return String
	 */
	public static String appendLetter(char[] letter, int maxChar) {
		StringBuffer sb = new StringBuffer();
		Random rand = new Random();
		
		for (int i = 0; i < maxChar; i++) {
            int ch = rand.nextInt(letter.length);  
            sb.append(letter [ch]);  
        }
		
		return sb.toString();
	}
}