package Candy;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testCandy() {
		int[] ratings = {1, 2, 3, 1,3};
		Solution s = new Solution();
		assertEquals("Candy number is not correct", 9, s.candy(ratings));
		int[] A = {1, 2, 2};
		assertEquals("Candy number is not correct", 4, s.candy(A));
	}

}
