package IntegerToRoman;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testIntToRoman() {
		Solution s = new Solution();
		int[] nums = {1954, 1990, 2014, 22};
		String[] Romans = {"MCMLIV", "MCMXC", "MMXIV", "XXII"};
		for (int i=0;i<nums.length;i++)
			assertEquals("The Roman converted from "+nums[i]+" is wrong", Romans[i], s.intToRoman(nums[i]));
	}

}
