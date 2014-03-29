package MinimumWindowSubstring;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testMinWindow() {
		Solution s = new Solution();
		String[] S = {"AbBaBBaabBb", "a", "a", "ADOBECODEBANC"}, T = {"AB", "b", "a", "ABC"}, ans = {"AbB", "", "a", "BANC"};
		for (int i=0;i<S.length;i++)
			assertEquals("Minimum window not agree", ans[i], s.minWindow(S[i], T[i]));
	}

}
