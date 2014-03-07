package LongestSubstringWithoutRepeatingCharacters;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testLengthOfLongestSubstring() {
		Solution s = new Solution();
		String[] strs = {"abcabcbb", "bbbbb"};
		int[] answer = {3, 1};
		for (int i=0;i<strs.length;i++)
			assertEquals("value not agree", answer[i], s.lengthOfLongestSubstring(strs[i]));
	}

}
