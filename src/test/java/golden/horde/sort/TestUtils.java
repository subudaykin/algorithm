package golden.horde.sort;

import java.util.Random;

public class TestUtils {

	private TestUtils(){
		// hide default constructor
	}
	
	public static int[] generateSortedArray(int length, int startValue, boolean isAscending){
		int[] result = new int[length];
		int direction = isAscending ? 1 : -1;
		for (int i = 0; i < result.length; i++) {
			result[i] = startValue + direction * i;
		}
		return result;
	}
	
	public static int[] generateFixedValueArray(int length, int value){
		int[] result = new int[length];
		for (int i = 0; i < result.length; i++) {
			result[i] = value;
		}
		return result;
	}
	
	public static int[] generateUnsortedArray(int length, int minValue, int maxValue){
		int[] result = new int[length];
		for (int i = 0; i < result.length; i++) {
			result[i] = generateRandomInt(minValue, maxValue);
		}
		return result;
	}
	
	private static Random random = new Random();
	
	public static int generateRandomInt(int minInclusive, int maxInclusive){
		int delta = maxInclusive - minInclusive;
		if (delta < 0)
			delta = -delta;
		return random.nextInt(++delta) + minInclusive;
	}
	
	public static boolean isArraySorted(int[] array){
		for(int i = 0; i < array.length - 1; i++){
			if (array[i] > array[i + 1])
				return false;
		}
		return true;
	}
	
}
