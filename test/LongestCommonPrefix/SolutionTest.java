package LongestCommonPrefix;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testLongestCommonPrefix() {
		Solution s = new Solution();
		String[] strs = {"abaa", "abcd", "abce"};
		assertEquals("Common prefix is not correct", "ab", s.longestCommonPrefix(strs));
	}

}
