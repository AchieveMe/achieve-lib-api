package vc.achieve.api.commons.generator;

/**
 * <p>Abstract class that encapsulate the 
 * same methods that classes will use it.<p>
 * 
 * @author GAN - <a href=˜mailto:guiandmag@gmail.com˜ />
 * @since 1.0
 */
public abstract class GeneratorDocument {
	
	/**
	 * <p>Util method that will receive a parameter and will transformer in a
	 * random number.</p>
	 * 
	 * @author GAN
	 * @since 1.0
	 * @param n
	 * @return Random Value
	 */
	protected static int randomValue(long n) {
		return (int) (Math.random() * n);
	}

	/**
	 * <p>Util method that will receive the random number and modify it.</p>
	 * 
	 * @author GAN
	 * @since 1.0
	 * @param dividendo
	 * @param divisor
	 * @return Modified value
	 */
	protected static int modifyValue(long dividendo, long divisor) {
		return (int) Math.round(dividendo - (Math.floor(dividendo / divisor) * divisor));
	}

	/**
	 * <p>Util method that generate the value with its count.</p>
	 * 
	 * @author GAN
	 * @since 1.0
	 * @param withPoints
	 * @return Generated Value
	 */
	protected abstract String generateValue(boolean withPoints);
	
}