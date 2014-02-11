package LongestConsecutiveSequence;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testLongestConsecutive() {
		int[] A = {100, 4, 200, 1, 3, 2};
		Solution s = new Solution();
		assertEquals("Longest sequence is not correct", 4, s.longestConsecutive(A));
		int[] B = {100, 0, 4, 1, 3, 2};
		assertEquals("Longest sequence is not correct", 5, s.longestConsecutive(B));
	}

}
