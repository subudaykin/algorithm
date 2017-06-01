package golden.horde.sort;

import static org.hamcrest.collection.IsArrayContaining.hasItemInArray;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class UtilsTest {

	@Test	
	public void sampleTest() {
		 List<Integer> list = Arrays.asList(5, 2, 4);
	     assertThat(list, hasSize(3));	     
	     assertThat(new String[] {"foo", "bar"}, hasItemInArray("bar"));
	}
	
	@Test
	public void testOne() {
		int[] actual = TestUtils.generateFixedValueArray(5, 11);
		int[] expected = new int[]{11, 11, 11, 11, 11};
	    assertArrayEquals("failure in ArrayGenerator.generateFixedValueArray", expected, actual);
	}

	@Test
	public void testTwo() {
		int[] actual = TestUtils.generateSortedArray(5, 19, true);
		int[] expected = new int[]{19, 20, 21, 22, 23};
	    assertArrayEquals("failure in ArrayGenerator.generateSortedArray", expected, actual);
	}
	
	@Test
	public void testThree() {
		int[] actual = TestUtils.generateSortedArray(5, 27, false);
		int[] expected = new int[]{27, 26, 25, 24, 23};
	    assertArrayEquals("failure in ArrayGenerator.generateSortedArray", expected, actual);
	}
	
	@Test
	public void testGenerateRandom(){
		Set<Integer> set = new HashSet<>();
		for(int i = 0; i < 100; i++){
			Integer val = TestUtils.generateRandomInt(3, 7);
			set.add(val);
		}
		assertThat(set, containsInAnyOrder(3, 4, 5, 6, 7));
	}
	
	@Test
	public void testGenerateRandom2(){
		Set<Integer> set = new HashSet<>();
		for(int i = 0; i < 100; i++){
			Integer val = TestUtils.generateRandomInt(-5, 2);
			set.add(val);
		}
		assertThat(set, containsInAnyOrder(-5, -4, -3, -2, -1, 0, 1, 2));
	}
	
	@Test
	public void testGenerateRandom3(){
		Set<Integer> set = new HashSet<>();
		for(int i = 0; i < 100; i++){
			Integer val = TestUtils.generateRandomInt(-11, -7);
			set.add(val);
		}
		assertThat(set, containsInAnyOrder(-11, -10, -9, -8, -7));
	}
	

}
