package vc.achieve.api.commons.generator;

import static vc.achieve.api.commons.generator.impl.PasswordGenerator.*;
import static vc.achieve.api.commons.generator.impl.WordGenerator.*;

import java.util.Random;

/**
 * <p> Interface that defines the method that generates
 * its values. </p>
 * 
 * @author GAN - <a href=˜mailto:guiandmag@gmail.com˜ />
 * @since 1.0
 */
public interface Generator {
	
	/**
	 * <p>Util method that generate the value with its count.</p>
	 * 
	 * @author GAN
	 * @since 1.0
	 * @return Generated Value (Plate)
	 */
	default String generateValue() {
		StringBuilder sb = new StringBuilder(this.generateValue(3, true) + "-");
		Random r = new Random();
		
		for (int i = 0; i < 4; i++) {
			sb.append(r.nextInt(10));
		}
		
		return sb.toString();
	}
	
	/**
	 * <p>Generator of random words.</p>
	 * 
	 * @param maxChar (int) number of characters in the word
	 * @param onlyLetter to generate only letters
	 * @author Alberto Cerqueira
	 * @since 1.0
	 * @return (String) random words
	 */
	default String generateValue(int maxChar, boolean onlyLetter) {
		final char[] letter = "ABCDEFGHIJKLMNOPQRSTUVWXYZÁÉÍÓÚÃÕÂÊÎÔÛÀÈÌÒÙÇ".toCharArray();
		final char[] letterOnly = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		
		if (onlyLetter) {
			return appendLetter(letterOnly, maxChar);
		} else {
			return appendLetter(letter, maxChar);
		}
	}
	
	/**
	 * Random password generator
	 * 
	 * @param maxChar (int) number of characters in the password
	 * @param level (int) level password (1 to 7):
	 * <ol>
	 *   <li> only lowercase </li>
	 *   <li> only lowercase and uppercase </li>
	 *   <li> letter and numbers </li>
	 *   <li> Substitutes for the @, and & i by 1, for $ s, x for % b by # and for 0 </li>
	 *   <li> special character every 3 characters </li>
	 *   <li> special character every 2 character </li>
	 *   <li> only special characters </li>
	 * </ol>
	 * 
	 * @author Alberto Cerqueira
	 * @since 1.0
	 * @return (String) random password
	 */
	default String generateValue(int maxChar, int level) {
		//chars
		Character[] c = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
                      'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                      '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};

		//chars special
		Character[] cs = {'`', '~', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '_', '-', '+', '=', '{', '}', '[', ']', '\'', '|', ':', ';', '\'', '<', '>', ',', '.', '?', '/'};
       
        StringBuilder password = new StringBuilder();
        
        for (int i = 0; i < maxChar; i++) {
        	int p1 = (int) (Math.random() * 26); //level 1
        	int p2 = (int) (Math.random() * 52); //level 2
        	int p  = (int) (Math.random() * c.length); //level 3 or +
        	int ps = (int) (Math.random() * cs.length); //level 3 or +
        	
        	if (level == 1) {
        		password.append(c[p1]);
        	} else if (level == 2) {
        		password.append(c[p2]);
        	} else if (level == 3) {
        		password.append(c[p]);
        	} else if (level == 4) {
        		String newL = replaceChar(c[p].toString());
        		password.append(newL);
        	} else if (level == 5) {
        		password.append(c[p]);
                if ((i % 3 == 0) && (i < maxChar - 1)) {
                	password.append(cs[ps]);
                    i++;
                }
        	} else if (level == 6) {
        		password.append(c[p]);
        		if ((i % 2 == 0) && (i < maxChar - 1)) {
        			password.append(cs[ps]);
                    i++;
                }
        	} else if (level == 7) {
        		password.append(cs[ps]);
        	} else {
        		password.append("password");
        		break;
        	}
        	
        }
        
        return password.toString();
    }
	
	/**
	 * <p>Util method that generate the value with its count.</p>
	 * 
	 * {@link CPFGenerator, CNPJGenerator}
	 * 
	 * @author GAN
	 * @since 1.0
	 * @param withPoints
	 * @return Generated Value (CNPJ)
	 */
	default String generateValueCNPJ(boolean withPoints) {
		int n = 9;
		int n1 = (int) (Math.random() * n);
		int n2 = (int) (Math.random() * n);
		int n3 = (int) (Math.random() * n);
		int n4 = (int) (Math.random() * n);
		int n5 = (int) (Math.random() * n);
		int n6 = (int) (Math.random() * n);
		int n7 = (int) (Math.random() * n);
		int n8 = (int) (Math.random() * n);
		int n9 = 0; 
		int n10 = 0; 
		int n11 = 0; 
		int n12 = 1; 
		
		long d1 = n12 * 2 + n11 * 3 + n10 * 4 + n9 * 5 + n8 * 6 + n7 * 7 + n6 * 8 + n5 * 9 + n4 * 2 + n3 * 3 + n2 * 4 + n1 * 5;
		
		d1 = 11 - ((int) Math.round(d1 - (Math.floor(d1 / 11) * 11)));
		
		if (d1 >= 10) {
			d1 = 0;
		}
		
		long d2 = d1 * 2 + n12 * 3 + n11 * 4 + n10 * 5 + n9 * 6 + n8 * 7 + n7 * 8 + n6 * 9 + n5 * 2 + n4 * 3 + n3 * 4 + n2 * 5 + n1 * 6;

		d2 = 11 - ((int) Math.round(d2 - (Math.floor(d2 / 11) * 11)));
		

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
	
	/**
	 * <p>Util method that generate the value with its count.</p>
	 * 
	 * {@link CPFGenerator, CNPJGenerator}
	 * 
	 * @author GAN
	 * @since 1.0
	 * @param withPoints
	 * @return Generated Value (CPF)
	 */
	default String generateValueCPF(boolean withPoints) {
		int n = 9;
		int n1 = (int) (Math.random() * n);
		int n2 = (int) (Math.random() * n);
		int n3 = (int) (Math.random() * n);
		int n4 = (int) (Math.random() * n);
		int n5 = (int) (Math.random() * n);
		int n6 = (int) (Math.random() * n);
		int n7 = (int) (Math.random() * n);
		int n8 = (int) (Math.random() * n);
		int n9 = (int) (Math.random() * n);
		int d1 = n9 * 2 + n8 * 3 + n7 * 4 + n6 * 5 + n5 * 6 + n4 * 7 + n3 * 8 + n2 * 9 + n1 * 10;

		d1 = 11 - ((int) Math.round(d1 - (Math.floor(d1 / 11) * 11)));

		if (d1 >= 10) {
			d1 = 0;
		}

		int d2 = d1 * 2 + n9 * 3 + n8 * 4 + n7 * 5 + n6 * 6 + n5 * 7 + n4 * 8 + n3 * 9 + n2 * 10 + n1 * 11;

		d2 = 11 - ((int) Math.round(d2 - (Math.floor(d2 / 11) * 11)));

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