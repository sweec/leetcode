package SingleNumber;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testSingleNumber() {
		int[] A = {1, 2, 1, 3, 3};
		Solution s = new Solution();
		assertEquals("Single number not detected", 2, s.singleNumber(A));
	}

}
