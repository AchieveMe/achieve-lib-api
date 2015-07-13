package vc.achieve.api.commons.util;

import java.util.HashMap;
import java.util.Map;

/**
 * <p> Util class to work with any <b>String</b>.</p>
 * 
 * @author Alberto Cerqueira - <a href=˜mailto:alberto.cerqueira1990@gmail.com˜ />
 * @since 1.0
 */
public class StringUtils {

	private static final int PAD_LIMIT = 8192;
	
	private static StringUtils instance = new StringUtils();

	public static StringUtils getInstance() {
		return instance;
	}
	
	/**
     * <p>Checks if a String is empty ("") or null.</p>
     * <pre>
     * StringUtils.isEmpty(null)      = true
     * StringUtils.isEmpty("")        = true
     * StringUtils.isEmpty(" ")       = false
     * StringUtils.isEmpty("bob")     = false
     * StringUtils.isEmpty("  bob  ") = false
     * </pre>
     * <p>NOTE: This method changed in Lang version 2.0. It no longer trims the String. That functionality is available in isBlank().</p>
     * @param str (String) the String to check, may be null
     * @return (boolean) <code>true</code> if the String is empty or null
     * 
     * @author Alberto Cerqueira
	 * @since 1.0
     */
    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }
    
    /**
	 * Verificar se a String esta vazia<br />
	 * Exemplos:
	 * <ul>
	 * 	 <li><code>" " == false</code></li>
	 * 	 <li><code>"" == true</code></li>
	 *   <li><code>"null" == true</code></li>
	 *   <li><code>null == true</code></li>
	 * </ul>
	 * @param value (String) valor para verificação
	 * @return (boolean) true para String vazia e false caso contrário
	 * 
	 * @author Alberto Cerqueira
	 * @since 1.0
	 */
    public static boolean isBlank(String value) {
		return (value == null || value.equals("") || value.equals("null") || value.trim().equals(""));
	}
    
	public static String leftPad(String str, String character, int size) {
		if (str != null) {
			int delta = size - str.length();
			for (int i = 0; i < delta; i++) {
				str = character + str;
			}
		}
		return str;
	}
	
	/**
     * <p>Right pad a String with spaces (' ').</p>
     * <p>The String is padded to the size of <code>size</code>.</p>
     * <pre>
     * StringUtils.rightPad(null, *)   = null
     * StringUtils.rightPad("", 3)     = "   "
     * StringUtils.rightPad("bat", 3)  = "bat"
     * StringUtils.rightPad("bat", 5)  = "bat  "
     * StringUtils.rightPad("bat", 1)  = "bat"
     * StringUtils.rightPad("bat", -1) = "bat"
     * </pre>
     * @param str (String) the String to pad out, may be null
     * @param size (int) the size to pad to
     * @return (String) right padded String or original String if no padding is necessary, <code>null</code> if null String input
     * @see spring.corp.framework.utils.StringUtils.rightPad(String, int, char)
     * 
     * @author Alberto Cerqueira
	 * @since 1.0
     */
    public static String rightPad(String str, int size) {
        return rightPad(str, size, ' ');
    }
    
    /**
     * <p>Right pad a String with a specified character.</p>
     * <p>The String is padded to the size of <code>size</code>.</p>
     * <pre>
     * StringUtils.rightPad(null, *, *)     = null
     * StringUtils.rightPad("", 3, 'z')     = "zzz"
     * StringUtils.rightPad("bat", 3, 'z')  = "bat"
     * StringUtils.rightPad("bat", 5, 'z')  = "batzz"
     * StringUtils.rightPad("bat", 1, 'z')  = "bat"
     * StringUtils.rightPad("bat", -1, 'z') = "bat"
     * </pre>
     * @param str (String) the String to pad out, may be null
     * @param size (int) the size to pad to
     * @param padChar (char) the character to pad with
     * @return (String) right padded String or original String if no padding is necessary, <code>null</code> if null String input
     * @since 2.0
     * 
     * @author Alberto Cerqueira
	 * @since 1.0
     */
    public static String rightPad(String str, int size, char padChar) {
        if (str == null) {
            return null;
        }
        int pads = size - str.length();
        if (pads <= 0) {
            return str; // returns original String when possible
        }
        if (pads > PAD_LIMIT) {
            return rightPad(str, size, String.valueOf(padChar));
        }
        return str.concat(padding(pads, padChar));
    }
    
    /**
     * <p>Right pad a String with a specified String.</p>
     * <p>The String is padded to the size of <code>size</code>.</p>
     * <pre>
     * StringUtils.rightPad(null, *, *)      = null
     * StringUtils.rightPad("", 3, "z")      = "zzz"
     * StringUtils.rightPad("bat", 3, "yz")  = "bat"
     * StringUtils.rightPad("bat", 5, "yz")  = "batyz"
     * StringUtils.rightPad("bat", 8, "yz")  = "batyzyzy"
     * StringUtils.rightPad("bat", 1, "yz")  = "bat"
     * StringUtils.rightPad("bat", -1, "yz") = "bat"
     * StringUtils.rightPad("bat", 5, null)  = "bat  "
     * StringUtils.rightPad("bat", 5, "")    = "bat  "
     * </pre>
     * @param str (String) the String to pad out, may be null
     * @param size (int) the size to pad to
     * @param padStr (String) the String to pad with, null or empty treated as single space
     * @return (String) right padded String or original String if no padding is necessary, <code>null</code> if null String input
     * 
     * @author Alberto Cerqueira
	 * @since 1.0
     */
    public static String rightPad(String str, int size, String padStr) {
        if (str == null) {
            return null;
        }
        if (isEmpty(padStr)) {
            padStr = " ";
        }
        int padLen = padStr.length();
        int strLen = str.length();
        int pads = size - strLen;
        if (pads <= 0) {
            return str; // returns original String when possible
        }
        if (padLen == 1 && pads <= PAD_LIMIT) {
            return rightPad(str, size, padStr.charAt(0));
        }

        if (pads == padLen) {
            return str.concat(padStr);
        } else if (pads < padLen) {
            return str.concat(padStr.substring(0, pads));
        } else {
            char[] padding = new char[pads];
            char[] padChars = padStr.toCharArray();
            for (int i = 0; i < pads; i++) {
                padding[i] = padChars[i % padLen];
            }
            return str.concat(new String(padding));
        }
    }
    
    /**
     * <p>Returns padding using the specified delimiter repeated to a given length.</p>
     * <pre>
     * StringUtils.padding(0, 'e')  = ""
     * StringUtils.padding(3, 'e')  = "eee"
     * StringUtils.padding(-2, 'e') = IndexOutOfBoundsException
     * </pre>
     * <p>Note: this method doesn't not support padding with
     * <a href="http://www.unicode.org/glossary/#supplementary_character">Unicode Supplementary Characters</a>
     * as they require a pair of <code>char</code>s to be represented.
     * If you are needing to support full I18N of your applications
     * consider using {@link #repeat(String, int)} instead. 
     * </p>
     *
     * @param repeat (int) number of times to repeat delim
     * @param padChar (char) character to repeat
     * @return (String) string with repeated character
     * @throws IndexOutOfBoundsException if <code>repeat &lt; 0</code>
     * @see #repeat(String, int)
     * 
     * @author Alberto Cerqueira
	 * @since 1.0
     */
    private static String padding(int repeat, char padChar) throws IndexOutOfBoundsException {
        if (repeat < 0) {
            throw new IndexOutOfBoundsException("Cannot pad a negative amount: " + repeat);
        }
        final char[] buf = new char[repeat];
        for (int i = 0; i < buf.length; i++) {
            buf[i] = padChar;
        }
        return new String(buf);
    }
    
    public static String normalizeOnlyLettersNumbers(String str) {
    	if (!StringUtils.isBlank(str)) {
    		return str.replaceAll("[^\\p{L}\\p{Nd}]+", "");
    	} else {
    		return "";
    	}
    }
    
    public static Map<String, String> makeOptions(String value) {
    	String[] options = value.split("(;)");
    	Map<String, String> mapOptions = new HashMap<String, String>();
		for (String option:options) {
			int posQuebra = option.indexOf(":");
			if (posQuebra > 0) {
				String chave = option.substring(0, posQuebra);
				String valor = option.substring(posQuebra+1);
				mapOptions.put(chave.trim(), valor.trim());
			}
		}
		return mapOptions;
    }
}