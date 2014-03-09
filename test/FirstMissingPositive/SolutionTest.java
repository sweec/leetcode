package FirstMissingPositive;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testFirstMissingPositive() {
		Solution s = new Solution();
		int[][] As = {{2, 2}, {1, 2, 0}, {3, 4, -1, 1}};
		int[] answer = {1, 3, 2};
		for (int i=0;i<As.length;i++)
			assertEquals("value not agree", answer[i], s.firstMissingPositive(As[i]));
	}

}
