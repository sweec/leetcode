package TwoSum;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testTwoSum() {
		int[] numbers={2, 7, 11, 15};
		int target = 9;
		Solution s = new Solution();
		int[] indexes = s.twoSum(numbers, target);
		assertEquals("1st index is not correct", 1, indexes[0]);
		assertEquals("2nd index is not correct", 2, indexes[1]);
		int[] num={11, 1000, 2000, 15};
		target = 3000;
		indexes = s.twoSum(num, target);
		assertEquals("1st index is not correct", 2, indexes[0]);
		assertEquals("2nd index is not correct", 3, indexes[1]);
	}

}
