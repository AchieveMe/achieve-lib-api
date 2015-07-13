package vc.achieve.api.commons.util;

import java.util.Arrays;

/**
 * <p> Util class to work with array.</p>
 * 
 * @author Alberto Cerqueira - <a href=˜mailto:alberto.cerqueira1990@gmail.com˜ />
 * @since 1.0
 * @version 1.1
 */
public class ArrayUtils {

	private int size;
	float[] values;
	boolean sorted;

	public void setSize(int si) {
		size = si;
	}

	public ArrayUtils(int size) {
		this.size = size;
		values = new float[size];
		sorted = false;
	}

	public ArrayUtils(float[] data) {
		this.size = data.length;
		sorted = false;
		values = data;
	}

	/**
	 * put a value to a index
	 * @param pos position in the array
	 * @param value value to put
	 * @return false if position does not exist
	 * 
	 * @author Alberto Cerqueira
	 * @since 1.0
	 */
	public boolean putValue(int pos, float value) {
		if (pos < size) {
			values[pos] = value;
			sorted = false;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Average value
	 * @return average value
	 * 
	 * @author Alberto Cerqueira
	 * @since 1.0
	 */
	public double getMean() {
		double total = 0;
		for (int i = 0; i < size; i++) {
			total += values[i];
		}
		return total / size;
	}

	/**
	 * The median (sorted array)
	 * @return mediane
	 * 
	 * @author Alberto Cerqueira
	 * @since 1.0
	 */
	public double medianSort() {
		if (!sorted) {
			sort();
		}
		if (size % 2 == 1) {
			return values[size / 2];
		} else {
			return (0.5f * (values[size / 2 - 1] + values[size / 2]));
		}
	}

	public void sort() {
		if (size < values.length) {
			float[] tosort = new float[size];
			System.arraycopy(values, 0, tosort, 0, size);
			Arrays.sort(tosort);
			System.arraycopy(tosort, 0, values, 0, size);
		} else {
			Arrays.sort(values);
		}
		sorted = true;
	}

	public boolean isMaximum(double val) {
		int i = 0;
		boolean maxok = true;
		while ((i < size) && (values[i] <= val)) {
			i++;
		}
		if (i < size) {
			maxok = false;
		}
		return maxok;
	}

	/**
	 * The minimum value
	 * @return min value
	 * 
	 * @author Alberto Cerqueira
	 * @since 1.0
	 */
	public double getMinimum() {
		double min = values[0];
		for (int i = 1; i < size; i++) {
			if (values[i] < min) {
				min = values[i];
			}
		}
		return min;
	}

	/**
	 * The maximum value
	 * @return max value
	 * 
	 * @author Alberto Cerqueira
	 * @since 1.0
	 */
	public double getMaximum() {
		double max = values[0];
		for (int i = 1; i < size; i++) {
			if (values[i] > max) {
				max = values[i];
			}
		}
		return max;
	}

	/**
	 * Variance value
	 * @return variance
	 * 
	 * @author Alberto Cerqueira
	 * @since 1.0
	 */
	public double getVariance() {
		if (size == 1) {
			return 0;
		}

		double total = 0;
		double total2 = 0;

		for (int i = 0; i < size; i++) {
			total += values[i];
			total2 += values[i] * values[i];
		}

		double var = (double) ((total2 - (total * total / size)) / (size - 1));
		return var;
	}

	/**
	 * information to be displayed
	 * @return text
	 * 
	 * @author Alberto Cerqueira
	 * @since 1.0
	 */
	public String toString() {
		String str = "{" + values[0];
		for (int i = 1; i < size; i++) {
			str = str + ", " + values[i];
		}
		return str + "}";
	}
	
	/**
     * is null or its length is 0
     * 
     * @param <V>
     * @param sourceArray
     * @return
     * 
     * @author Alberto Cerqueira
	 * @since 1.0
     */
    public static <V> boolean isEmpty(V[] sourceArray) {
        return (sourceArray == null || sourceArray.length == 0);
    }
    
    /**
     * get last element of the target element, before the first one that match the target element front to back
     * <ul>
     * <li>if array is empty, return defaultValue</li>
     * <li>if target element is not exist in array, return defaultValue</li>
     * <li>if target element exist in array and its index is not 0, return the last element</li>
     * <li>if target element exist in array and its index is 0, return the last one in array if isCircle is true, else
     * return defaultValue</li>
     * </ul>
     * 
     * @param <V>
     * @param sourceArray
     * @param value value of target element
     * @param defaultValue default return value
     * @param isCircle whether is circle
     * @return
     * 
     * @author Alberto Cerqueira
	 * @since 1.1
     */
    public static <V> V getLast(V[] sourceArray, V value, V defaultValue, boolean isCircle) {
        if (isEmpty(sourceArray)) {
            return defaultValue;
        }

        int currentPosition = -1;
        for (int i = 0; i < sourceArray.length; i++) {
            if (ObjectUtils.isEquals(value, sourceArray[i])) {
                currentPosition = i;
                break;
            }
        }
        if (currentPosition == -1) {
            return defaultValue;
        }

        if (currentPosition == 0) {
            return isCircle ? sourceArray[sourceArray.length - 1] : defaultValue;
        }
        return sourceArray[currentPosition - 1];
    }

    /**
     * get next element of the target element, after the first one that match the target element front to back
     * <ul>
     * <li>if array is empty, return defaultValue</li>
     * <li>if target element is not exist in array, return defaultValue</li>
     * <li>if target element exist in array and not the last one in array, return the next element</li>
     * <li>if target element exist in array and the last one in array, return the first one in array if isCircle is
     * true, else return defaultValue</li>
     * </ul>
     * 
     * @param <V>
     * @param sourceArray
     * @param value value of target element
     * @param defaultValue default return value
     * @param isCircle whether is circle
     * @return
     * 
     * @author Alberto Cerqueira
	 * @since 1.1
     */
    public static <V> V getNext(V[] sourceArray, V value, V defaultValue, boolean isCircle) {
        if (isEmpty(sourceArray)) {
            return defaultValue;
        }

        int currentPosition = -1;
        for (int i = 0; i < sourceArray.length; i++) {
            if (ObjectUtils.isEquals(value, sourceArray[i])) {
                currentPosition = i;
                break;
            }
        }
        if (currentPosition == -1) {
            return defaultValue;
        }

        if (currentPosition == sourceArray.length - 1) {
            return isCircle ? sourceArray[0] : defaultValue;
        }
        return sourceArray[currentPosition + 1];
    }

    /**
     * @see {@link ArrayUtils#getLast(Object[], Object, Object, boolean)} defaultValue is null
     * 
     * @author Alberto Cerqueira
	 * @since 1.1
     */
    public static <V> V getLast(V[] sourceArray, V value, boolean isCircle) {
        return getLast(sourceArray, value, null, isCircle);
    }

    /**
     * @see {@link ArrayUtils#getNext(Object[], Object, Object, boolean)} defaultValue is null
     * 
     * @author Alberto Cerqueira
	 * @since 1.1
     */
    public static <V> V getNext(V[] sourceArray, V value, boolean isCircle) {
        return getNext(sourceArray, value, null, isCircle);
    }

    /**
     * @see {@link ArrayUtils#getLast(Object[], Object, Object, boolean)} Object is Long
     * 
     * @author Alberto Cerqueira
	 * @since 1.1
     */
    public static long getLast(long[] sourceArray, long value, long defaultValue, boolean isCircle) {
        if (sourceArray.length == 0) {
        	throw new IllegalArgumentException("O comprimento da matriz deve ser superior a 0.");
        }

        Long[] array = ObjectUtils.transformLongArray(sourceArray);
        return getLast(array, value, defaultValue, isCircle);

    }

    /**
     * @see {@link ArrayUtils#getNext(Object[], Object, Object, boolean)} Object is Long
     * 
     * @author Alberto Cerqueira
	 * @since 1.1
     */
    public static long getNext(long[] sourceArray, long value, long defaultValue, boolean isCircle) {
        if (sourceArray.length == 0) {
        	throw new IllegalArgumentException("O comprimento da matriz deve ser superior a 0.");
        }

        Long[] array = ObjectUtils.transformLongArray(sourceArray);
        return getNext(array, value, defaultValue, isCircle);
    }
    
    /**
     * @see {@link ArrayUtils#getLast(Object[], Object, Object, boolean)} Object is Integer
     * 
     * @author Alberto Cerqueira
	 * @since 1.1
     */
    public static int getLast(int[] sourceArray, int value, int defaultValue, boolean isCircle) {
        if (sourceArray.length == 0) {
        	throw new IllegalArgumentException("O comprimento da matriz deve ser superior a 0.");
        }

        Integer[] array = ObjectUtils.transformIntArray(sourceArray);
        return getLast(array, value, defaultValue, isCircle);

    }

    /**
     * @see {@link ArrayUtils#getNext(Object[], Object, Object, boolean)} Object is Integer
     * 
     * @author Alberto Cerqueira
	 * @since 1.1
     */
    public static int getNext(int[] sourceArray, int value, int defaultValue, boolean isCircle) {
        if (sourceArray.length == 0) {
            throw new IllegalArgumentException("O comprimento da matriz deve ser superior a 0.");
        }

        Integer[] array = ObjectUtils.transformIntArray(sourceArray);
        return getNext(array, value, defaultValue, isCircle);
    }
}