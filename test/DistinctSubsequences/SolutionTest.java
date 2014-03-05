package DistinctSubsequences;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testNumDistinct() {
		Solution s = new Solution();
		String S = "rabbbit", T = "rabbit";
		assertEquals("number not agree", 3, s.numDistinct(S, T));
	}

}
