package vc.achieve.api.commons.generator;

import java.util.Random;

/**
 * <p> Util class that generates a random but valid <b>Placa</b>
 * for the Brazil territory. </p>
 * 
 * @author Alberto Cerqueira - <a href=˜mailto:alberto.cerqueira1990@gmail.com˜ />
 * @since 1.0
 */
public class Placa {

	/**
	 * Random generator plates
	 * @return (String) random placa
	 * 
	 * @author Alberto Cerqueira
	 * @since 1.0
	 */
	public static String get() {
		StringBuilder sb = new StringBuilder(Word.getOnlyLetters(3) + "-");
		Random r = new Random();
		for (int i = 0; i < 4; i++) {
			sb.append(r.nextInt(10));
		}
		return sb.toString();
	}
}