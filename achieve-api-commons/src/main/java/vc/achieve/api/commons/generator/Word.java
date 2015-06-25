package vc.achieve.api.commons.generator;

import java.util.Random;

/**
 * <p> Util class that generates a random but valid <b>Strings</b> and <b>Words</b>.</p>
 * 
 * @author Alberto Cerqueira - <a href=˜mailto:alberto.cerqueira1990@gmail.com˜ />
 * @since 1.0
 */
public class Word {

	/**
	 * Generator of random words
	 * @param maxChar (int) number of characters in the word
	 * @return (String) random words
	 * 
	 * @author Alberto Cerqueira
	 * @since 1.0
	 */
	public static String get(int maxChar) {
    	Random rand = new Random();
    	char[] letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZÁÉÍÓÚÃÕÂÊÎÔÛÀÈÌÒÙÇ".toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < maxChar; i++) {
            int ch = rand.nextInt(letras.length);  
            sb.append(letras [ch]);  
        }      
        return sb.toString();      
    }
	
	/**
	 * Generator of random words (only letters)
	 * @param maxChar (int) number of characters in the word
	 * @return (String) random words
	 * 
	 * @author Alberto Cerqueira
	 * @since 1.0
	 */
	public static String getOnlyLetters(int maxChar) {
    	Random rand = new Random();
    	char[] letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < maxChar; i++) {
            int ch = rand.nextInt(letras.length);  
            sb.append(letras [ch]);  
        }      
        return sb.toString();      
    }
}