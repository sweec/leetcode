package DivideTwoIntegers;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testDivide() {
		Solution s = new Solution();
		int[] dividends = {Integer.MIN_VALUE, 9, 3, -3, -3};
		int[] divisors = {2, 2, -2, 2, -2};
		int[] ans = {Integer.MIN_VALUE>>1, 4, -1, -1, 1};
		for (int i=0;i<divisors.length;i++)
			assertEquals("result not agree", ans[i], s.divide(dividends[i], divisors[i]));
	}

}
