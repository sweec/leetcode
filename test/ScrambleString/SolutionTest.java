package ScrambleString;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testIsScramble() {
		Solution s = new Solution();
		String[] s1s = {"great", "great", "ccabcbabcbabbbbcbb"};
		String[] s2s = {"rgeat", "rgtae", "bbbbabccccbbbabcba"};
		boolean[] as = {true, true, false};
		for (int i=0;i<s1s.length;i++)
			assertEquals("result not agree", as[i], s.isScramble(s1s[i], s2s[i]));
	}

}
