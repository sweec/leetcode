package SearchForARange;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testSearchRange() {
		Solution s = new Solution();
		int[] A = {5, 7, 7, 8, 8, 10};
		int target = 10;
		int[] answer = {5, 5};
		int[] range = s.searchRange(A, target);
		for (int i=0;i<answer.length;i++)
			assertEquals("range value wrong", answer[i], range[i]);
	}

}
