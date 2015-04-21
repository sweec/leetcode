package ReverseWordsInAString;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testReverseWords() {
		Solution s = new Solution();
		String[] strs = {"", " the  sky is  blue ", "the sky is blue"};
		String[] ans = {"", "blue is sky the", "blue is sky the"};
		for (int i=0;i<ans.length;i++)
			assertEquals("Reverse string with words not agree", ans[i], s.reverseWords(strs[i]));
	}

}
