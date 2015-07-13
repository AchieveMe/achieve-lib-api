package vc.achieve.api.commons.util;

/**
 * <p> Util class to work with any <b>Object</b>.</p>
 * 
 * @author Alberto Cerqueira - <a href=˜mailto:alberto.cerqueira1990@gmail.com˜ />
 * @since 1.0
 */
public class ObjectUtils {

	private ObjectUtils() {
		throw new AssertionError();
	}
	
    /**
     * Compare two object
     * @param actual (Object) to compare
     * @param expected (Object) to compare
     * @return <ul>
     *         <li>if both are null, return true</li>
     *         <li>return actual.{@link Object#equals(Object)}</li>
     *         </ul>
     * 
     * @author Alberto Cerqueira
	 * @since 1.0
     */
    public static boolean isEquals(Object actual, Object expected) {
        return actual == expected || (actual == null ? expected == null : actual.equals(expected));
    }

    /**
     * null Object to empty string
     * <pre>
     * nullStrToEmpty(null) = &quot;&quot;;
     * nullStrToEmpty(&quot;&quot;) = &quot;&quot;;
     * nullStrToEmpty(&quot;aa&quot;) = &quot;aa&quot;;
     * </pre>
     * 
     * @param str
     * @return
     * 
     * @author Alberto Cerqueira
	 * @since 1.0
     */
    public static String nullStrToEmpty(Object str) {
        return (str == null ? "" : (str instanceof String ? (String) str : str.toString()));
    }

    /**
     * Convert long array to Long array
     * @param source (long[]) array to convert
     * @return (Long[]) array converted
     * 
     * @author Alberto Cerqueira
	 * @since 1.0
     */
    public static Long[] transformLongArray(long[] source) {
        Long[] destin = new Long[source.length];
        for (int i = 0; i < source.length; i++) {
            destin[i] = source[i];
        }
        return destin;
    }

    /**
     * convert Long array to long array
     * @param source (Long[]) array to convert
     * @return (long[]) array converted
     * 
     * @author Alberto Cerqueira
	 * @since 1.0
     */
    public static long[] transformLongArray(Long[] source) {
        long[] destin = new long[source.length];
        for (int i = 0; i < source.length; i++) {
            destin[i] = source[i];
        }
        return destin;
    }

    /**
     * convert int array to Integer array
     * @param source (int[]) array to convert
     * @return (Integer[]) array converted
     * 
     * @author Alberto Cerqueira
	 * @since 1.0
     */
    public static Integer[] transformIntArray(int[] source) {
        Integer[] destin = new Integer[source.length];
        for (int i = 0; i < source.length; i++) {
            destin[i] = source[i];
        }
        return destin;
    }

    /**
     * convert Integer array to int array
     * @param source (Integer[]) array to convert
     * @return (int[]) array converted
     * 
     * @author Alberto Cerqueira
	 * @since 1.0
     */
    public static int[] transformIntArray(Integer[] source) {
        int[] destin = new int[source.length];
        for (int i = 0; i < source.length; i++) {
            destin[i] = source[i];
        }
        return destin;
    }

    /**
     * compare two object
     * @param v1
     * @param v2
     * @return <V> <ul>
     * 			     <strong>About result</strong>
     * 			     <li>if v1 > v2, return 1</li>
     * 			     <li>if v1 = v2, return 0</li>
     * 			     <li>if v1 < v2, return -1</li>
     * 			   </ul>
     * 			   <ul>
     * 			     <strong>About rule</strong>
     * 			     <li>if v1 is null, v2 is null, then return 0</li>
     * 				 <li>if v1 is null, v2 is not null, then return -1</li>
     * 				 <li>if v1 is not null, v2 is null, then return 1</li>
     * 				 <li>return v1.{@link Comparable#compareTo(Object)}</li>
     * 			   </ul>
     * 
     * @author Alberto Cerqueira
	 * @since 1.0
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static <V> int compare(V v1, V v2) {
        return v1 == null ? (v2 == null ? 0 : -1) : (v2 == null ? 1 : ((Comparable) v1).compareTo(v2));
    }
}