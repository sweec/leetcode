package LongestValidParentheses;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testLongestValidParentheses() {
		Solution s = new Solution();
		String[] strs = {"(()", ")()())", "()(()", "()()(()", "(()(((()"};
		int[] lengths = {2, 4, 2, 4, 2};
		for (int i=0;i<strs.length;i++)
			assertEquals("Get wrong valid length of "+strs[i], lengths[i], s.longestValidParentheses(strs[i]));
	}

}
