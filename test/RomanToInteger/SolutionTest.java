package RomanToInteger;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testRomanToInt() {
		Solution s = new Solution();
		int[] nums = {1954, 1990, 2014, 22};
		String[] Romans = {"MCMLIV", "MCMXC", "MMXIV", "XXII"};
		for (int i=0;i<nums.length;i++)
			assertEquals("The integer converted from "+Romans[i]+" is wrong", nums[i], s.romanToInt(Romans[i]));
	}

}
