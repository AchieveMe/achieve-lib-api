package vc.achieve.api.commons.generator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p> Util class that generates a random but valid <b>CPF</b>
 * for the Brazil territory. </p>
 * 
 * @author GAN - <a href=˜mailto:guiandmag@gmail.com˜ />
 * @since 1.0
 */
public class CPFGenerator extends GeneratorDocument {
	
	private static Logger LOGGER = LoggerFactory.getLogger(CPFGenerator.class);
	
	/**
	 * <p>Private field to hold the unique instance of the object.</p>
	 * 
	 * @author GAN
	 * @since 1.0
	 */
    private static final CPFGenerator INSTANCE = new CPFGenerator();
    
    /**
	 * <h2>Singleton Patterns</h2>
	 * 
	 * <p>Utility class, there is no need to be instantiated. Prevent to be created at reflection
	 * a second CPFGenerator at runtime.</p>
	 * 
	 * @author GAN
	 * @since 1.0
	 */
    private CPFGenerator() {
    	if(CPFGenerator.INSTANCE != null) {
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
    public static CPFGenerator getInstance() {
    	LOGGER.debug("{} was instantiated", CPFGenerator.class.getName());
    	
    	return CPFGenerator.INSTANCE;
    }

	@Override
	protected String generateValue(boolean withPoints) {
		int n = 9;
		int n1 = randomValue(n);
		int n2 = randomValue(n);
		int n3 = randomValue(n);
		int n4 = randomValue(n);
		int n5 = randomValue(n);
		int n6 = randomValue(n);
		int n7 = randomValue(n);
		int n8 = randomValue(n);
		int n9 = randomValue(n);
		int d1 = n9 * 2 + n8 * 3 + n7 * 4 + n6 * 5 + n5 * 6 + n4 * 7 + n3 * 8 + n2 * 9 + n1 * 10;

		d1 = 11 - (modifyValue(d1, 11));

		if (d1 >= 10) {
			d1 = 0;
		}

		int d2 = d1 * 2 + n9 * 3 + n8 * 4 + n7 * 5 + n6 * 6 + n5 * 7 + n4 * 8 + n3 * 9 + n2 * 10 + n1 * 11;

		d2 = 11 - (modifyValue(d2, 11));

		if (d2 >= 10) {
			d2 = 0;
		}
		
		String ret = null;

		if (withPoints) {
			ret = "" + n1 + n2 + n3 + '.' + n4 + n5 + n6 + '.' + n7 + n8 + n9 + '-' + d1 + d2;
		} else {
			ret = "" + n1 + n2 + n3 + n4 + n5 + n6 + n7 + n8 + n9 + d1 + d2;
		}

		return ret;
	}
}