package golden.horde.sort;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class SorterTest {

	private ISorter sorter;

	public SorterTest(ISorter sorter) {
		this.sorter = sorter;
	}

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { 
			{ new SelectSorter() }, 
			{ new BubbleSorter() }, 
			{ new InsertSorter() }, 
			{ new MergeSorter() }/*,
			{ new ShellSorter() }*/});
	}
	
	@Test
	public void auxiliaryTest(){
		int[] source = new int[]{3, 2, 11, 7, 5, 15, 2};
		new MergeSorter().sort(source);
	}

	@Test
	//@Ignore
	public void testSortedArray() {
		for (int i = 0; i < 100; i++) {
			int[] source = _generateSourceArray(true, true, Integer.MIN_VALUE);
			sorter.sort(source);
			assertTrue("failure in " + sorter.description(), TestUtils.isArraySorted(source));
			source = _generateSourceArray(true, false, Integer.MIN_VALUE);
			sorter.sort(source);
			assertTrue("Fail to sort a sorted array by " + sorter.description(), TestUtils.isArraySorted(source));
		}
	}
	
	@Test
	public void testUnsortedArray(){
		for (int i = 0; i < 100; i++) {
			int[] source = _generateSourceArray(false, false, Integer.MIN_VALUE);
			sorter.sort(source);
			assertTrue("Fail to sort a unsorted array by " + sorter.description(), TestUtils.isArraySorted(source));
		}
	}
	
	@Test
	public void testFixedValueArray(){
		for (int i = 0; i < 1000; i++) {
			int[] source = _generateSourceArray(false, false, i - 500);
			sorter.sort(source);
			assertTrue("Fail to sort a fixed-value array by " + sorter.description(), TestUtils.isArraySorted(source));
		}
	}

	private int[] _generateSourceArray(boolean isSorted, boolean isAscending, int fixedValue) {		
		int length = TestUtils.generateRandomInt(MIN_ARRAY_LENGTH, MAX_ARRAY_LENGTH);
		if (fixedValue != Integer.MIN_VALUE)
			return TestUtils.generateFixedValueArray(length, fixedValue);
		int minValue = TestUtils.generateRandomInt(MIN_ARRAY_ITEM_VALUE, MAX_ARRAY_ITEM_VALUE);
		if (isSorted) {
			return TestUtils.generateSortedArray(length, minValue, isAscending);
		} else {
			int maxValue = minValue + TestUtils.generateRandomInt(0, MAX_ARRAY_ITEM_VALUE);
			return TestUtils.generateUnsortedArray(length, minValue, maxValue);
		}
	}
	
	private final int MIN_ARRAY_LENGTH = 1;	
	private final int MAX_ARRAY_LENGTH = 1000;
	private final int MIN_ARRAY_ITEM_VALUE = -1000;	
	private final int MAX_ARRAY_ITEM_VALUE = 1000;
	

}
