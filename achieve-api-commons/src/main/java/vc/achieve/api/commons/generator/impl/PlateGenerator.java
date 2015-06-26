package vc.achieve.api.commons.generator.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import vc.achieve.api.commons.generator.Generator;

/**
 * <p> Util class that generates a random but valid <b>Plate</b>
 * for the Brazil territory. </p>
 * 
 * @author Alberto Cerqueira - <a href=˜mailto:alberto.cerqueira1990@gmail.com˜ />
 * @since 1.0
 */
public class PlateGenerator implements Generator {

	private static Logger LOGGER = LoggerFactory.getLogger(PlateGenerator.class);
	
	/**
	 * <p>Private field to hold the unique instance of the object.</p>
	 * 
	 * @author GAN
	 * @since 1.0
	 */
    private static final PlateGenerator INSTANCE = new PlateGenerator();
    
    /**
	 * <h2>Singleton Patterns</h2>
	 * 
	 * <p>Utility class, there is no need to be instantiated. Prevent to be created at reflection
	 * a second CPFGenerator at runtime.</p>
	 * 
	 * @author GAN
	 * @since 1.0
	 */
    private PlateGenerator() {
    	if(PlateGenerator.INSTANCE != null) {
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
    public static PlateGenerator getInstance() {
    	LOGGER.debug("{} was already instantiated", PlateGenerator.class.getName());
    	
    	return PlateGenerator.INSTANCE;
    }
	
}