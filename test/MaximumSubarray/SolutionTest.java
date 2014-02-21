package MaximumSubarray;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testMaxSubArray() {
		Solution s = new Solution();
		int[] A = {-2,1,-3,4,-1,2,1,-5,4};
		assertEquals("Get wrong max sum", 6, s.maxSubArray(A));
	}

}
