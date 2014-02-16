package LongestPalindromicSubstring;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testLongestPalindrome() {
		Solution s = new Solution();
		String[] strs = {"baaa", "mississipi", "aabba"};
		String[] pars = {"aaa", "ississi", "abba"};
		for (int i=0;i<strs.length;i++)
			assertEquals("Longest parlindrome of "+strs[i]+" is not detected", pars[i], s.longestPalindrome(strs[i]));
	}

}
