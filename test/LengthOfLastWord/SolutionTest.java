package LengthOfLastWord;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testLengthOfLastWord() {
		Solution s = new Solution();
		String[] strs = {"Hello World", "  ", " test ", "another   "};
		int[] lengths = {5, 0, 4, 7};
		for (int i=0;i<strs.length;i++)
			assertEquals("Get wrong length of last word of "+strs[i], lengths[i], s.lengthOfLastWord(strs[i]));
	}

}
