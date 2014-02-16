package RegularExpressionMatching;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testIsMatch() {
		Solution s = new Solution();
		String[] strs = {"aa", "aa", "aaa", "aa", "aa", "ab", "aab"};
		String[] patterns = {"a", "aa", "aa", "a*", ".*", ".*", "c*a*b*"};
		boolean match[] = {false, true, false, true, true, true, true};
		for (int i=0;i<strs.length;i++)
			assertEquals("Match "+strs[i]+" for "+patterns[i]+" not correct", match[i], s.isMatch(strs[i], patterns[i]));
	}

}
