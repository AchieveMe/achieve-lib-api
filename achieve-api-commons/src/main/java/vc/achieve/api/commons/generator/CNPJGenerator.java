package vc.achieve.api.commons.generator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p> Util class that generates a random but valid <b>CNPJ</b>
 * for the Brazil territory. </p>
 * 
 * @author GAN - <a href=˜mailto:guiandmag@gmail.com˜ />
 * @since 1.0
 */
public final class CNPJGenerator extends GeneratorDocument {
	
	private static Logger LOGGER = LoggerFactory.getLogger(CNPJGenerator.class);
	
	/**
	 * <p>Private field to hold the unique instance of the object.</p>
	 * 
	 * @author GAN
	 * @since 1.0
	 */
    private static final CNPJGenerator INSTANCE = new CNPJGenerator();
	
	/**
	 * <h2>Singleton Patterns</h2>
	 * 
	 * <p>Utility class, there is no need to be instantiated. Prevent to be created at reflection
	 * a second CNPJGenerator at runtime.</p>
	 * 
	 * @author GAN
	 * @since 1.0
	 */
	private CNPJGenerator() {
		if(CNPJGenerator.INSTANCE != null) {
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
	public static CNPJGenerator getInstance() {
		LOGGER.debug("{} was instantiated", CNPJGenerator.class.getName());
		
		return CNPJGenerator.INSTANCE;
	}
	
	@Override
	public String generateValue(boolean withPoints) {
		int n = 9;
		int n1 = randomValue(n);
		int n2 = randomValue(n);
		int n3 = randomValue(n);
		int n4 = randomValue(n);
		int n5 = randomValue(n);
		int n6 = randomValue(n);
		int n7 = randomValue(n);
		int n8 = randomValue(n);
		int n9 = 0; 
		int n10 = 0; 
		int n11 = 0; 
		int n12 = 1; 
		
		long d1 = n12 * 2 + n11 * 3 + n10 * 4 + n9 * 5 + n8 * 6 + n7 * 7 + n6 * 8 + n5 * 9 + n4 * 2 + n3 * 3 + n2 * 4 + n1 * 5;
		
		d1 = 11 - (modifyValue(d1, 11));
		
		if (d1 >= 10) {
			d1 = 0;
		}
		
		long d2 = d1 * 2 + n12 * 3 + n11 * 4 + n10 * 5 + n9 * 6 + n8 * 7 + n7 * 8 + n6 * 9 + n5 * 2 + n4 * 3 + n3 * 4 + n2 * 5 + n1 * 6;

		d2 = 11 - (modifyValue(d2, 11));

		if (d2 >= 10) {
			d2 = 0;
		}
		
		String ret = null;
		
		if (withPoints) {
			ret = "" + n1 + n2 + "." + n3 + n4 + n5 + "." + n6 + n7 + n8 + "/" + n9 + n10 + n11 + n12 + "-" + d1 + d2;
		} else {
			ret = "" + n1 + n2 + n3 + n4 + n5 + n6 + n7 + n8 + n9 + n10 + n11 + n12 + d1 + d2;
		}

		return ret;
	}
}